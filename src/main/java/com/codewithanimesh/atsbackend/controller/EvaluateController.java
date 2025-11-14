package com.codewithanimesh.atsbackend.controller;

import com.codewithanimesh.atsbackend.model.ATSScore;
import com.codewithanimesh.atsbackend.model.JobDescription;
import com.codewithanimesh.atsbackend.model.Resume;
import com.codewithanimesh.atsbackend.service.ATSMatchingService;
import com.codewithanimesh.atsbackend.service.JDParserService;
import com.codewithanimesh.atsbackend.service.ResumeParserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EvaluateController {

    private final ResumeParserService resumeParser = new ResumeParserService();
    private final JDParserService jdParser = new JDParserService();
    private final ATSMatchingService matcher = new ATSMatchingService();

    // Accepts {"resume": { ... }, "jd": { ... }} or just resume/jd objects directly
    @PostMapping(value = "/evaluate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ATSScore evaluate(@RequestBody EvaluateRequest payload) {
        Resume resume = payload.getResume();
        JobDescription jd = payload.getJd();

        if (resume == null) resume = new Resume();
        if (jd == null) jd = new JobDescription();

        resumeParser.parse(resume);
        jdParser.parse(jd);

        return matcher.match(resume, jd);
    }

    // small wrapper class for request body
    public static class EvaluateRequest {
        private Resume resume;
        private JobDescription jd;

        public Resume getResume() { return resume; }
        public void setResume(Resume resume) { this.resume = resume; }

        public JobDescription getJd() { return jd; }
        public void setJd(JobDescription jd) { this.jd = jd; }
    }
}