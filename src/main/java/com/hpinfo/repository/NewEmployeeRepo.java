package com.hpinfo.repository;

import com.hpinfo.entity.NewEmpEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewEmployeeRepo extends ReactiveCrudRepository<NewEmpEntity, String> {
}
