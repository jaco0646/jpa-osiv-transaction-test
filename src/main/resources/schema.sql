create table if not exists entity (
    id          int         GENERATED ALWAYS AS IDENTITY,
    foo         text        not null,
    bar         text        not null,
    primary key (id)
);

create table if not exists entity1 (
    id          int         GENERATED ALWAYS AS IDENTITY,
    number_one  int         not null,
    number_two  int         not null,
    primary key (id)
);

create view if not exists entity1_view as
    select
        id as id,
        number_one::text as number_one,
        number_two::text as number_two
    from entity1
;

create table if not exists entity2 (
    id  int         GENERATED ALWAYS AS IDENTITY,
    b1  boolean     not null,
    b2  boolean,
    primary key (id)
);