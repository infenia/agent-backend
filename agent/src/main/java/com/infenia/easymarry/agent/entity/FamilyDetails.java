package com.infenia.easymarry.agent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FamilyDetails {
        private String father;
        private String mother;
        private List<String> siblings;
    }


