package com.codewithanimesh.atsbackend.controller;

import com.codewithanimesh.atsbackend.model.Resume;
import com.codewithanimesh.atsbackend.model.JobDescription;
import com.codewithanimesh.atsbackend.model.ATSScore;
import com.codewithanimesh.atsbackend.service.ResumeParserService;
import com.codewithanimesh.atsbackend.service.JDParserService;
import com.codewithanimesh.atsbackend.service.ATSMatchingService;

public class MainController {
    public static void main(String[] args) {
        System.out.println("ATS Optimizer starting...");

        Resume r = new Resume("Animesh", "animesh@example.com", "9999999999");
        r.setRawText("Experienced backend dev. Worked with Java, Spring Boot, REST APIs, Docker and PostgreSQL.");
        r.setExperienceText("3 years building backend services and REST APIs.");

        ResumeParserService rp = new ResumeParserService();
        rp.parse(r);

        JobDescription jd = new JobDescription("Backend Developer", "ACME Corp");
        jd.setRawText("We need a backend developer with Java, Spring Boot, REST API and Docker experience. PostgreSQL is a plus.");

        JDParserService jdp = new JDParserService();
        jdp.parse(jd);

        ATSMatchingService matcher = new ATSMatchingService();
        ATSScore s = matcher.match(r, jd);

        System.out.println("Resume skills: " + r.getSkills());
        System.out.println("JD skills: " + jd.getRequiredSkills());
        System.out.println("ATSScore: " + s);
    }
}