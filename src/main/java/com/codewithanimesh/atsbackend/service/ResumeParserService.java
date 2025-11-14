package com.codewithanimesh.atsbackend.service;

import com.codewithanimesh.atsbackend.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ResumeParserService {

    // Simple built-in skill lexicon. Expand this as you go.
    private static final List<String> SKILL_LEXICON = Arrays.asList(
            "java", "spring", "spring boot", "hibernate", "sql", "postgresql", "mysql",
            "rest", "rest api", "microservices", "docker", "kubernetes",
            "python", "c++", "git", "aws", "azure", "javascript", "react"
    );

    // Pre-compile word boundaries for safer matching
    private static final List<Pattern> SKILL_PATTERNS = buildPatterns();

    private static List<Pattern> buildPatterns() {
        List<Pattern> patterns = new ArrayList<>();
        for (String s : SKILL_LEXICON) {
            // word boundary, case-insensitive
            patterns.add(Pattern.compile("\\b" + Pattern.quote(s) + "\\b", Pattern.CASE_INSENSITIVE));
        }
        return patterns;
    }

    /**
     * Naive extraction: finds skills mentioned in rawText and sets them on the Resume object.
     * This doesn't perform stemming or NLP — simple keyword matching that's easy to extend.
     */
    public Resume parse(Resume resume) {
        if (resume == null) return null;
        String raw = resume.getRawText();
        if (raw == null) raw = "";

        Set<String> found = new HashSet<>();
        for (int i = 0; i < SKILL_PATTERNS.size(); i++) {
            Pattern p = SKILL_PATTERNS.get(i);
            if (p.matcher(raw).find()) {
                found.add(SKILL_LEXICON.get(i));
            }
        }

        // normalize and add to resume skills
        List<String> skills = new ArrayList<>(found);
        resume.setSkills(skills);
        return resume;
    }
}