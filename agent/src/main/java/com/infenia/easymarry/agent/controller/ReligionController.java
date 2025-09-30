package com.infenia.easymarry.agent.controller;

import com.infenia.easymarry.agent.entity.Religion;
import com.infenia.easymarry.agent.service.ReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/religion")
public class ReligionController { // Fixed class name capitalization

    @Autowired
    private ReligionService religionService;

    @GetMapping("/{userId}") // Fixed path variable name
    public Mono<String> getAllReligions(@PathVariable long userId) {
        return religionService.getAllReligions(userId);
    }


    @PutMapping("/insert")
    public Mono<Religion> createReligion(@RequestBody Religion religion) {
        return religionService.createReligion(religion);
    }

    @PutMapping("/{userId}")
    public Mono<Religion> updateReligion(@PathVariable long userId, @RequestBody Religion religion) {
        return religionService.updateReligion(userId, religion);
    }

}