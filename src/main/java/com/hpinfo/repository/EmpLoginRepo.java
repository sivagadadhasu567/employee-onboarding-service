package com.hpinfo.repository;

import com.hpinfo.entity.LoginEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EmpLoginRepo extends ReactiveCrudRepository<LoginEntity, String> {
    Mono<Object> findByEmail(String email);
}
