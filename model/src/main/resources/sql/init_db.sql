create table salons
(
    id serial not null
        constraint salon_key primary key,
    salonName varchar(255) not null ,
    address varchar(255)not null ,
    hasGiftCertificate boolean,
    genderType varchar(255),
    workTime varchar(255),
    workersQnt int
)

