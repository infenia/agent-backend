package com.infenia.easymarry.agent.service;

import com.infenia.easymarry.agent.entity.Family;
import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public Flux<Family> getAllFamilies() {
        return familyRepository.findAll();
    }

    public Mono<Family> getFamilyByUserId(Long userId) {
        return familyRepository.findById(userId)
                .switchIfEmpty(Mono.error(new RuntimeException("Family not found with id " + userId)));
    }

    public Mono<Family> createFamily(Family family) {
        return familyRepository.save(family);
    }

    public Mono<Family> updateFamily(Long userId, Family updated) {
        return familyRepository.findById(userId)
                .flatMap(existing -> {
                    Family newFamily = new Family(
                            existing.userid(),
                            updated.familyDetails(),
                            existing.createdBy(),
                            updated.updatedBy(),
                            existing.createdAt(),
                            Instant.now(),
                            existing.version(),
                            updated.familyType(),
                            updated.familyClass(),
                            updated.familyValues()
                    );
                    return familyRepository.save(newFamily);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Family not found with id " + userId)));
    }

    public Mono<Void> deleteFamily(Long userId) {
        return familyRepository.deleteById(userId);
    }
}
