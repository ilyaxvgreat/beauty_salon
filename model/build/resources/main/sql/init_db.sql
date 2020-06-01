-- create table salons
-- (
--     id serial not null
--         constraint salon_key primary key,
--     salonName varchar(255) not null ,
--     address varchar(255)not null ,
--     hasGiftCertificate boolean,
--     genderType varchar(255),
--     workTime varchar(255),
--     workersQnt int
-- )
create table salon_services(
    id serial not null constraint salon_services_key primary key ,
    service_name varchar(255) not null ,
    price int not null ,
    duration int not null
)
