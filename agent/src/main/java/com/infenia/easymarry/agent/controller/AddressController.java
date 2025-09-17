package com.infenia.easymarry.agent.controller;
import com.infenia.easymarry.agent.Entity.AddressEntity;
import com.infenia.easymarry.agent.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{userId}/address")
    public Mono<AddressEntity> getAddressByUserId(@PathVariable Long userId) {
        return addressService.getAddressByUserId(userId);
    }
}


