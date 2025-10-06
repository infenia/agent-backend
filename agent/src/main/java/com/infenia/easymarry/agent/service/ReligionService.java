package com.infenia.easymarry.agent.service;

import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.repository.ReligionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ReligionService {
    @Autowired
    private ReligionRepository religionRepository;

    public Flux<Religion> getAllReligions() {
        return religionRepository.findAll();
    }

//    public Mono<String> getAllReligions(long userId) {
//        return religionRepository.findReligionByUserId(userId)
//                .map(Religion::getReligion)
//                .switchIfEmpty(Mono.just("religion not found"));
//    }

    public Mono<Religion> getReligionByUserId(Long userId) {
        return religionRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("Religion not found for userId: " + userId)));
    }

    public Mono<Religion> createReligion(Religion religion) {

        return religionRepository.save(religion);
    }

    public Mono<Religion> updateReligion(Long userId, Religion religion) {
        return religionRepository.findById(userId)
                .flatMap(existing -> {
                    existing.setReligion(religion.getReligion());
                    existing.setCaste(religion.getCaste());
                    existing.setSubcaste(religion.getSubcaste());
                    existing.setUpdatedBy(religion.getUpdatedBy());
                    return religionRepository.save(existing);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Religion not found for userId: " + userId)));
    }
    public Mono<Void> deleteReligion(Long userId) {
        return religionRepository.deleteById(userId);
    }

}