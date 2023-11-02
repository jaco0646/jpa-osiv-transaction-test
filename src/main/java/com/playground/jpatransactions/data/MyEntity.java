package com.playground.jpatransactions.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entity")
@Getter
@Setter
@ToString
public class MyEntity implements SuperInterfaceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String foo;

    @Convert(converter = StringReverser.class)
    private String bar;
}
