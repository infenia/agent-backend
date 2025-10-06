package com.infenia.easymarry.agent.repository;

import com.infenia.easymarry.agent.entity.Religion;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface ReligionRepository extends ReactiveCrudRepository<Religion, Long> {
    //@Query("SELECT * FROM iuser.religion WHERE user_id = :userId")
    //Mono<Religion> findReligionByUserId(@Param("userId") Long userId); // Use Mono for reactive
}