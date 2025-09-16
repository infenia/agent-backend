package com.infenia.easymarry.agent.controller;

import com.infenia.easymarry.agent.service.ReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}