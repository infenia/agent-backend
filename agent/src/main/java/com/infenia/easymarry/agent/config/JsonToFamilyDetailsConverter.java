package com.infenia.easymarry.agent.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infenia.easymarry.agent.entity.FamilyDetails;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class JsonToFamilyDetailsConverter implements Converter<Json, FamilyDetails> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public FamilyDetails convert(Json source) {
        try {
            // Convert the Postgres JSON object to FamilyDetails
            return mapper.readValue(source.asString(), FamilyDetails.class);
        } catch (Exception e) {
            throw new RuntimeException("Error converting JSON to FamilyDetails", e);
        }
    }
}
