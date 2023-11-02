package com.playground.jpatransactions.repository;

import com.playground.jpatransactions.data.MyEntity;
import com.playground.jpatransactions.data.SuperInterfaceDTO;
import com.playground.jpatransactions.data.UnrelatedInterfaceDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends CrudRepository<MyEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from entity where id = :id")
    SuperInterfaceDTO findSuperInterfaceById(int id);

    @Query(nativeQuery = true, value = "select * from entity where id = :id")
    UnrelatedInterfaceDTO findUnrelatedInterfaceById(int id);

    // Column aliases are required without a native query.
    @Query("select foo as foo, bar as bar from MyEntity where id = :id")
    UnrelatedInterfaceDTO findJpaFieldsById(int id);

    @Query(nativeQuery = true, value = "select * from entity where id = :id")
    Tuple findTupleById(int id);

    <T> T findById(int id, Class<T> dto);
}