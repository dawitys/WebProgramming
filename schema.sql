
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
       id bigint not null auto_increment,
        name varchar(255) not null,
        added_on datetime,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table subject (
       id bigint not null auto_increment,
        identity varchar(255),
        added_on datetime,
        tought_by_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table subject_registration (
       id bigint not null auto_increment,
        grade double precision not null,
        registrated_at datetime,
        student_id bigint,
        subject_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table teacher (
       id bigint not null auto_increment,
        age integer not null,
        name varchar(255) not null,
        added_on datetime,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB

    create table users (
       id bigint not null auto_increment,
        enabled integer,
        password varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table news 
       add constraint FK9q17s4qtv7elpg5qr727jg7g6 
       foreign key (posted_by_id) 
       references users (id)

    alter table student 
       add constraint FKk0thg920a3xk3v59yjbsatw1l 
       foreign key (user_id) 
       references users (id)

    alter table subject 
       add constraint FKb1jckacx4885a65k9fs73ww5l 
       foreign key (tought_by_id) 
       references teacher (id)

    alter table subject_registration 
       add constraint FKqebdg83j0ag8wynqxtr0esf8c 
       foreign key (student_id) 
       references student (id)

    alter table subject_registration 
       add constraint FKq0kipyc2adyy7kqu2jk6e4531 
       foreign key (subject_id) 
       references subject (id)

    alter table teacher 
       add constraint FKcp1vpkh4bh0qux9vtvs0fkwrn 
       foreign key (user_id) 
       references users (id)

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id)

    alter table user_role 
       add constraint FKj345gk1bovqvfame88rcx7yyx 
       foreign key (user_id) 
       references users (id)
