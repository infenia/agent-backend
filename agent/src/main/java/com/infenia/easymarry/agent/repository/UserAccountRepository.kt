package com.infenia.easymarry.agent.repository

import com.example.agent.model.UserAccount
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface UserAccountRepository : ReactiveCrudRepository<UserAccount, Long> {

    fun findByEmail(email: String): Mono<UserAccount>

    fun findByMobile(mobile: String): Mono<UserAccount>

    fun findByIdpUserId(idpUserId: String): Mono<UserAccount>

    @Query("SELECT * FROM iuser.user_account WHERE is_active = true")
    fun findAllActiveUsers(): Flux<UserAccount>
}
