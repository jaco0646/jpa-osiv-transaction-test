package com.playground.jpatransactions.controller;

import com.playground.jpatransactions.data.Entity1DTO;
import com.playground.jpatransactions.data.Entity1View;
import com.playground.jpatransactions.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MyController {
    private final MyService service;

    @GetMapping("/")
    public String get() {
        return "Hello, World!";
    }

    @GetMapping("/{id}")
    public Entity1DTO getByID(@PathVariable int id) {
        return service.getEntity1(id);
    }

    @PostMapping("/{id}/increment")
    public Entity1View incrementByID(@PathVariable int id, @RequestParam int times) {
        return service.increment(id, times);
    }
}
