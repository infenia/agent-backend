package com.infenia.easymarry.agent.service;

import com.infenia.easymarry.agent.entity.Family;
import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<Family> updateFamily(Long userId, Family family) {
        return familyRepository.findById(userId)
                .flatMap(existing -> {
                    // Update only the fields you want to change
                    existing.setFamilyDetails(family.getFamilyDetails());
                    existing.setFamilyType(family.getFamilyType());
                    existing.setFamilyClass(family.getFamilyClass());
                    existing.setFamilyValues(family.getFamilyValues());

                    // Do NOT set createdBy or updatedBy manually
                    return familyRepository.save(existing);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Family not found with id " + userId)));
    }

    public Mono<Void> deleteFamily(Long userId) {
        return familyRepository.deleteById(userId);
    }
}
