package com.infenia.easymarry.agent.entity;

import java.util.List;

public record FamilyDetails(
        String father,
        String mother,
        List<String> siblings
) {}
