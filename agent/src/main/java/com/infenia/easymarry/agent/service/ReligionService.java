package com.infenia.easymarry.agent.service;

import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.repository.ReligionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReligionService {
    @Autowired
    private ReligionRepository religionRepository;

    public Mono<String> getAllReligions(long userId) {
        return religionRepository.findReligionByUserId(userId)
                .map(Religion::getReligion)
                .switchIfEmpty(Mono.just("religion not found"));
    }
}