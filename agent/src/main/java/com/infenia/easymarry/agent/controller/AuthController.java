package com.infenia.easymarry.agent.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  public static final Map<String, String> USERS = new HashMap<>();

  static {
    USERS.put("admin", "admin123");
    USERS.put("user", "user123");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(
      @RequestParam String username, @RequestParam String password) {
    if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
      return ResponseEntity.ok("Login successful for user: " + username);
    } else {
      return ResponseEntity.status(401).body("Invalid credentials");
    }
  }
}
