package com.codewithanimesh.atsbackend.dto;

import java.util.List;

public class EvaluateResponseDTO {
    private double overallScore;
    private double skillMatchScore;
    private double experienceMatchScore;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private List<String> extraSkills;
    private String feedback;

    public double getOverallScore() { return overallScore; }
    public void setOverallScore(double overallScore) { this.overallScore = overallScore; }

    public double getSkillMatchScore() { return skillMatchScore; }
    public void setSkillMatchScore(double skillMatchScore) { this.skillMatchScore = skillMatchScore; }

    public double getExperienceMatchScore() { return experienceMatchScore; }
    public void setExperienceMatchScore(double experienceMatchScore) { this.experienceMatchScore = experienceMatchScore; }

    public List<String> getMatchedSkills() { return matchedSkills; }
    public void setMatchedSkills(List<String> matchedSkills) { this.matchedSkills = matchedSkills; }

    public List<String> getMissingSkills() { return missingSkills; }
    public void setMissingSkills(List<String> missingSkills) { this.missingSkills = missingSkills; }

    public List<String> getExtraSkills() { return extraSkills; }
    public void setExtraSkills(List<String> extraSkills) { this.extraSkills = extraSkills; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}
