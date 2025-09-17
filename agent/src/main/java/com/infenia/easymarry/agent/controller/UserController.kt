package com.infenia.easymarry.agent.controller

import com.infenia.easymarry.agent.model.UserAccount
import com.infenia.easymarry.agent.service.UserAccountService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/users")
class UserAccountController(
    private val userAccountService: UserAccountService
) {

    @GetMapping
    fun getAllUsers(): Flux<UserAccount> =
        userAccountService.getAllUsers()

    @GetMapping("/active")
    fun getActiveUsers(): Flux<UserAccount> =
        userAccountService.getActiveUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): Mono<UserAccount> =
        userAccountService.getUserById(id)

    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String): Mono<UserAccount> =
        userAccountService.getUserByEmail(email)

    @GetMapping("/mobile/{mobile}")
    fun getUserByMobile(@PathVariable mobile: String): Mono<UserAccount> =
        userAccountService.getUserByMobile(mobile)

    @GetMapping("/idp/{idpUserId}")
    fun getUserByIdpUserId(@PathVariable idpUserId: String): Mono<UserAccount> =
        userAccountService.getUserByIdpUserId(idpUserId)
}
