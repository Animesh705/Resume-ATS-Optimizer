package com.codewithanimesh.atsbackend.service;

import com.codewithanimesh.atsbackend.model.JobDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class JDParserService {

    // Keep the same lexicon as resume parser for now (you can unify later)
    private static final List<String> SKILL_LEXICON = Arrays.asList(
            "java", "spring", "spring boot", "hibernate", "sql", "postgresql", "mysql",
            "rest", "rest api", "microservices", "docker", "kubernetes",
            "python", "c++", "git", "aws", "azure", "javascript", "react"
    );

    private static final List<Pattern> SKILL_PATTERNS = buildPatterns();

    private static List<Pattern> buildPatterns() {
        List<Pattern> patterns = new ArrayList<>();
        for (String s : SKILL_LEXICON) {
            patterns.add(Pattern.compile("\\b" + Pattern.quote(s) + "\\b", Pattern.CASE_INSENSITIVE));
        }
        return patterns;
    }

    public JobDescription parse(JobDescription jd) {
        if (jd == null) return null;
        String raw = jd.getRawText();
        if (raw == null) raw = "";

        Set<String> found = new HashSet<>();
        for (int i = 0; i < SKILL_PATTERNS.size(); i++) {
            if (SKILL_PATTERNS.get(i).matcher(raw).find()) {
                found.add(SKILL_LEXICON.get(i));
            }
        }

        jd.setRequiredSkills(new ArrayList<>(found));
        return jd;
    }
}