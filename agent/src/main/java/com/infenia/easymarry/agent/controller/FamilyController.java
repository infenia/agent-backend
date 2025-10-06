package com.infenia.easymarry.agent.controller;

import com.infenia.easymarry.agent.entity.Family;
import com.infenia.easymarry.agent.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @GetMapping("/{userId}")
    public Mono<Family> getFamilyByUserId(@PathVariable long userId) {
        return familyService.getFamilyByUserId(userId);
    }

    @GetMapping("/all")
    public Flux<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    @PutMapping("/insert")
    public Mono<Family> createFamily( @RequestBody Family family) {
        return familyService.createFamily(family);
    }

    @PutMapping("/{userId}")
    public Mono<Family> updateFamily(@PathVariable long userId, @RequestBody Family family) {
        return familyService.updateFamily(userId, family);
    }

    @DeleteMapping("/{userId}")
    public Mono<Void> deleteFamily(@PathVariable long userId) {
        return familyService.deleteFamily(userId);
    }
}
