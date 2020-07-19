create sequence jpa_estimate_detail_sequence start 7 increment 1;
create sequence jpa_estimate_sequence start 3 increment 1;
create sequence jpa_mark_up_sequence start 3 increment 1;
create sequence jpa_payment_sequence start 5 increment 1;
create sequence jpa_project_sequence start 11 increment 1;
create table estimate
(
    id          int8   not null,
    cost        float8 not null,
    name        varchar(255),
    not_payment float8 not null,
    payment     float8 not null,
    performance float8 not null,
    project_id  int8,
    primary key (id)
);
create table estimate_detail
(
    id           int8    not null,
    category     varchar(255),
    complete     boolean not null,
    cost         float8  not null,
    cost_client  float8  not null,
    estimate_id  int8,
    name         varchar(255),
    price        float8  not null,
    price_client float8  not null,
    quantity     float8  not null,
    unit         varchar(255),
    primary key (id)
);
create table mark_up
(
    id              int4   not null,
    mark_up_name    varchar(255),
    mark_up_percent float8 not null,
    primary key (id)
);
create table payment
(
    id            int8   not null,
    amount        float8 not null,
    category      varchar(255),
    comment       varchar(2048),
    date          date,
    estimate_id   int8   not null,
    estimate_name varchar(255),
    project_id    int8   not null,
    primary key (id)
);
create table project
(
    id            int8 not null,
    address       varchar(255),
    contract      varchar(255),
    creation_date date,
    description   varchar(2048),
    name          varchar(255),
    owner         varchar(255),
    primary key (id)
)