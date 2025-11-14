package com.codewithanimesh.atsbackend.model;

import java.util.List;

public class EvaluationResult {
    private double score;
    private List<String> keywordsMatched;
    private List<String> missingKeywords;
    private List<String> suggestedBullets;

    public EvaluationResult() {
    }

    public EvaluationResult(double score, List<String> keywordsMatched, List<String> missingKeywords, List<String> suggestedBullets) {
        this.score = score;
        this.keywordsMatched = keywordsMatched;
        this.missingKeywords = missingKeywords;
        this.suggestedBullets = suggestedBullets;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getKeywordsMatched() {
        return keywordsMatched;
    }

    public void setKeywordsMatched(List<String> keywordsMatched) {
        this.keywordsMatched = keywordsMatched;
    }

    public List<String> getMissingKeywords() {
        return missingKeywords;
    }

    public void setMissingKeywords(List<String> missingKeywords) {
        this.missingKeywords = missingKeywords;
    }

    public List<String> getSuggestedBullets() {
        return suggestedBullets;
    }

    public void setSuggestedBullets(List<String> suggestedBullets) {
        this.suggestedBullets = suggestedBullets;
    }
}