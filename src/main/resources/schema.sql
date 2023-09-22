-- create table "geoJson" with owner postgres;
create extension if not exists "uuid-ossp";

create table if not exists geoJson
(
    id UUID unique not null default uuid_generate_v1() primary key,
    country_name varchar(50) unique not null,
    country_code varchar(4) unique not null,
    coordinates json
);

alter table geoJson
    owner to postgres;
