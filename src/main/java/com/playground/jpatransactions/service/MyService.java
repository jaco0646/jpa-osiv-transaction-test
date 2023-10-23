package com.playground.jpatransactions.service;

import com.playground.jpatransactions.data.Entity1;
import com.playground.jpatransactions.data.Entity1DTO;
import com.playground.jpatransactions.data.Entity1View;
import com.playground.jpatransactions.repository.Entity1Repository;
import com.playground.jpatransactions.repository.Entity1ViewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class MyService {
    private final Entity1Repository repo;
    private final Entity1ViewRepository view;

    public Entity1DTO getEntity1(int id) {
        return repo.viewByID(id);
    }

    /**
     * The 'before' view becomes stale when OSIV == true,
     * because the view is a managed bean which isn't touched between the first and last lines.
     */
    public Entity1View increment(int id, int times) {
        Entity1View before = view.findById(id).orElseThrow();
        log.info("Before increment: " + before.getNumberOne() + " & " + before.getNumberTwo());
        for (int i = 0; i < times; i++) {
            increment(id);
        }
        return view.findById(id).orElseThrow();
    }

    private void increment(int id) {
        Entity1 entity = repo.findById(id).orElseThrow();
        entity.setNumberOne(entity.getNumberOne() + 1);
        entity.setNumberTwo(entity.getNumberTwo() + 1);
        repo.save(entity);
    }
}
