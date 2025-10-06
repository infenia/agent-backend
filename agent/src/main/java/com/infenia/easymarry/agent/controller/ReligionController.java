package com.infenia.easymarry.agent.controller;

import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.service.ReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/religion")
public class ReligionController { // Fixed class name capitalization

    @Autowired
    private ReligionService religionService;

    @GetMapping("/all")
    public Flux<Religion> getAllReligions() {
        return religionService.getAllReligions();
    }

    @GetMapping("/{userId}") // Fixed path variable name
    public Mono<Religion> getReligionByUserId(@PathVariable long userId) {
        return religionService.getReligionByUserId(userId);
    }


    @PutMapping("/insert")
    public Mono<Religion> createReligion(@RequestBody Religion religion) {
        return religionService.createReligion(religion);
    }

    @PutMapping("/{userId}")
    public Mono<Religion> updateReligion(@PathVariable long userId, @RequestBody Religion religion) {
        return religionService.updateReligion(userId, religion);
    }

    @DeleteMapping("/{userId}")
    public Mono<Void> deleteReligion(@PathVariable long userId) {
        return religionService.deleteReligion(userId);
    }

}