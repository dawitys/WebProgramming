
    create table news (
       id bigint not null auto_increment,
        content varchar(255),
        posted_at datetime,
        title varchar(255),
        posted_by_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table role (
       id bigint not null auto_increment,
        role varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table student (
       id bigint not null,
        name varchar(255) not null,
        added_on datetime,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table subject (
       id bigint not null,
        grade integer not null,
        identity varchar(255),
        added_on datetime,
        primary key (id)
    ) engine=InnoDB;

    create table subject_registration (
       id bigint not null,
        grade double not null,
        registrated_at datetime,
        student_id bigint,
        subject_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table teacher (
       id bigint not null,
        age integer not null,
        name varchar(255) not null,
        added_on datetime,
        user_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null auto_increment,
        enabled integer,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        phone_number varchar(255),
        username varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table user_role (
       user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    ) engine=InnoDB;

    alter table news 
       add constraint FKem6iqx4q0cx14mvbbgkr1ptfd 
       foreign key (posted_by_id) 
       references user (id);

    alter table student 
       add constraint FKk5m148xqefonqw7bgnpm0snwj 
       foreign key (user_id) 
       references user (id);

    alter table subject_registration 
       add constraint FKqebdg83j0ag8wynqxtr0esf8c 
       foreign key (student_id) 
       references student (id);

    alter table subject_registration 
       add constraint FKq0kipyc2adyy7kqu2jk6e4531 
       foreign key (subject_id) 
       references subject (id);

    alter table teacher 
       add constraint FKpb6g6pahj1mr2ijg92r7m1xlh 
       foreign key (user_id) 
       references user (id);

    alter table user_role 
       add constraint FKa68196081fvovjhkek5m97n3y 
       foreign key (role_id) 
       references role (id);

    alter table user_role 
       add constraint FK859n2jvi8ivhui0rl0esws6o 
       foreign key (user_id) 
       references user (id);