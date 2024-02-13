package com.playground.jpatransactions.repository;

import com.playground.jpatransactions.data.Entity2;
import com.playground.jpatransactions.data.Entity2DTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity2Repository extends CrudRepository<Entity2, Integer> {
    @Query(nativeQuery = true, value = """
            select id,
                   b1 as b1,
                   b2 as b2
            from entity2 where id = :id""")
    Entity2DTO.Get prefixWithGet(int id);

    @Query(nativeQuery = true, value = """
            select id,
                   b1 as isB1,
                   b2 as isB2
            from entity2 where id = :id""")
    Entity2DTO.GetIs prefixWithGetIs(int id);

    @Query(nativeQuery = true, value = """
            select id,
                   b1 as b1,
                   b2 as b2
            from entity2 where id = :id""")
    Entity2DTO.IsGet prefixWithIs(int id);
}
