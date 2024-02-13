package com.playground.jpatransactions.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entity2")
@Getter
@Setter
@ToString
public class Entity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean b1;
    private Boolean b2;
}
