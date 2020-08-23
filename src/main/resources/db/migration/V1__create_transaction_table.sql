create table transaction (
    id serial not null,
    created_date timestamp not null,
    description varchar(120) not null,
    user_id int4 not null check (user_id>=1000 AND user_id<=100000000),
    value numeric(19, 2) not null,
    primary key (id))