package com.infenia.easymarry.agent.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infenia.easymarry.agent.entity.FamilyDetails;
import io.r2dbc.postgresql.codec.Json;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@WritingConverter
public class FamilyDetailsToJsonConverter implements Converter<FamilyDetails, Json> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Json convert(FamilyDetails source) {
        try {
            return Json.of(mapper.writeValueAsString(source));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting FamilyDetails to JSON", e);
        }
    }
}
