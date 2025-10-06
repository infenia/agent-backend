package com.infenia.easymarry.agent.repository;

import com.infenia.easymarry.agent.entity.Family;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FamilyRepository extends R2dbcRepository<Family, Long> {

}
