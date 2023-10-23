package com.playground.jpatransactions.repository;

import com.playground.jpatransactions.data.Entity1;
import com.playground.jpatransactions.data.Entity1DTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entity1Repository extends CrudRepository<Entity1, Integer> {
    @Query(nativeQuery = true, value = """
            select id,
                   number_one as numberOne,
                   number_two as numberTwo
            from entity1_view where id = :id""")
    Entity1DTO viewByID(int id);
}
