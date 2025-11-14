package com.codewithanimesh.atsbackend.service;

import com.codewithanimesh.atsbackend.model.ATSScore;
import com.codewithanimesh.atsbackend.model.JobDescription;
import com.codewithanimesh.atsbackend.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ATSMatchingService {

    /**
     * Simple matching:
     * - skillMatchScore = % of JD required skills found in resume
     * - experienceMatchScore = naive length-based heuristic
     * - overallScore = weighted (70% skill, 30% experience)
     */
    public ATSScore match(Resume resume, JobDescription jd) {
        ATSScore score = new ATSScore();

        List<String> jdSkills = jd.getRequiredSkills() == null ? new ArrayList<>() : jd.getRequiredSkills();
        List<String> resumeSkills = resume.getSkills() == null ? new ArrayList<>() : resume.getSkills();

        if (jdSkills.isEmpty()) {
            score.setSkillMatchScore(100.0);
        } else {
            int matched = 0;
            List<String> missing = new ArrayList<>();
            for (String req : jdSkills) {
                boolean found = resumeSkills.stream().anyMatch(rs -> rs.equalsIgnoreCase(req));
                if (found) matched++;
                else missing.add(req);
            }
            double skillPercent = (matched * 100.0) / jdSkills.size();
            score.setSkillMatchScore(round(skillPercent));
            score.setMissingSkills(missing);
        }

        String exp = resume.getExperienceText() == null ? "" : resume.getExperienceText().trim();
        double expScore;
        if (exp.isEmpty()) expScore = 20.0;
        else if (exp.length() < 100) expScore = 50.0;
        else expScore = 85.0;
        score.setExperienceMatchScore(round(expScore));

        double overall = score.getSkillMatchScore() * 0.7 + score.getExperienceMatchScore() * 0.3;
        score.setOverallScore(round(overall));

        return score;
    }

    private double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}