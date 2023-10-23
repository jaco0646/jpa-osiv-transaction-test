package com.playground.jpatransactions.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entity1")
@Getter
@Setter
@ToString
public class Entity1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numberOne;
    private int numberTwo;
}
