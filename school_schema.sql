
    create table class_room (
       id bigint not null,
        identity varchar(255),
        added_on datetime,
        grade_level integer,
        section integer,
        primary key (id)
    ) engine=InnoDB

    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table news (
       id bigint not null auto_increment,
        content varchar(255),
        posted_at datetime,
        title varchar(255),
        posted_by_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table student (
       id bigint not null,
        age integer not null,
        added_on datetime,
        first_name varchar(255) not null,
        identity varchar(255),
        last_name varchar(255) not null,
        password varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table subject (
       id bigint not null,
        grade integer not null,
        identity varchar(255),
        added_on datetime,
        level integer not null,
        subject integer not null,
        primary key (id)
    ) engine=InnoDB

    create table teacher (
       id bigint not null,
        age integer not null,
        identity varchar(255),
        added_on datetime,
        first_name varchar(255) not null,
        last_name varchar(255) not null,
        password varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user (
       id bigint not null auto_increment,
        delivery_city varchar(255),
        delivery_state varchar(255),
        delivery_street varchar(255),
        delivery_zip varchar(255),
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    alter table news 
       add constraint FKem6iqx4q0cx14mvbbgkr1ptfd 
       foreign key (posted_by_id) 
       references user (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id)
