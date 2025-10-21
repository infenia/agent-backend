package com.infenia.easymarry.agent.Repository;
import com.infenia.easymarry.agent.Entity.AddressEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface AddressRepository extends R2dbcRepository<AddressEntity, Long> {
    Mono<AddressEntity> findByUserId(Long userId);
}


