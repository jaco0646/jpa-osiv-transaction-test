package com.playground.jpatransactions.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entity1_view")
@Getter
@Setter
@ToString
public class Entity1View {
    @Id
    private int id;

    private String numberOne;
    private String numberTwo;
}
