package com.playground.jpatransactions.repository;

import com.playground.jpatransactions.data.SuperInterfaceDTO;
import com.playground.jpatransactions.data.MyEntity;
import com.playground.jpatransactions.data.UnrelatedInterfaceDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<MyEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from entity where id = :id")
    SuperInterfaceDTO findSuperInterfaceById(int id);

    @Query(nativeQuery = true, value = "select * from entity where id = :id")
    UnrelatedInterfaceDTO findUnrelatedInterfaceById(int id);
}