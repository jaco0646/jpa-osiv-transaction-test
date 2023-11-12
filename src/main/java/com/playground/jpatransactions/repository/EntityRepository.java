package com.playground.jpatransactions.repository;

import com.playground.jpatransactions.data.MyEntity;
import com.playground.jpatransactions.data.SuperInterfaceDTO;
import com.playground.jpatransactions.data.UnrelatedInterfaceDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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

    default Map<Integer, String> findFoosByIDs(Collection<Integer> ids) {
        return findTuplesByIDs(ids).collect(toMap(
                tuple -> (Integer) tuple.get(0),
                tuple -> (String) tuple.get(1)
        ));
    }

    @Query("select id, foo from MyEntity where id in :ids")
    Stream<Tuple> findTuplesByIDs(Collection<Integer> ids);
}