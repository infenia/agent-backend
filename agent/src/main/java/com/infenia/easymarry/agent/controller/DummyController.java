package com.infenia.easymarry.agent.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @GetMapping("/api/dummy")
    public String dummyApi() {
        return "This is a dummy API response ";
    }
}
