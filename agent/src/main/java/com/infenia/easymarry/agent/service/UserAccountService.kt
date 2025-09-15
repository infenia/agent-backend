package com.infenia.easymarry.agent.service

import com.example.agent.model.UserAccount
import com.example.agent.repository.UserAccountRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserAccountService(
    private val userAccountRepository: UserAccountRepository
) {

    fun getAllUsers(): Flux<UserAccount> =
        userAccountRepository.findAll()

    fun getActiveUsers(): Flux<UserAccount> =
        userAccountRepository.findAllActiveUsers()

    fun getUserById(userId: Long): Mono<UserAccount> =
        userAccountRepository.findById(userId)

    fun getUserByEmail(email: String): Mono<UserAccount> =
        userAccountRepository.findByEmail(email)

    fun getUserByMobile(mobile: String): Mono<UserAccount> =
        userAccountRepository.findByMobile(mobile)

    fun getUserByIdpUserId(idpUserId: String): Mono<UserAccount> =
        userAccountRepository.findByIdpUserId(idpUserId)
}
