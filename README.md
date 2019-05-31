# Spring-Boot-Second-Project
This project is about Issue management
#### Using Tools & Technologies
``` 
- Spring Boot
- Spring Security
- JWT
- REST API, DTO
- Jpa, Hibernate
- PostgreSql
- Angular 7
- Typescript
- Bootstrap 4
``` 
#### Sql Query
``` 
CREATE TABLE public.users
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(100) COLLATE pg_catalog."default",
    status boolean,
    updated_at timestamp without time zone,
    updated_by character varying(100) COLLATE pg_catalog."default",
    email character varying(100) COLLATE pg_catalog."default",
    pwd character varying(300) COLLATE pg_catalog."default",
    surname character varying(100) COLLATE pg_catalog."default",
    uname character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_iqm8x8lkitrfo4idy96trfm9p UNIQUE (uname)

)

CREATE TABLE public.project
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(100) COLLATE pg_catalog."default",
    status boolean,
    updated_at timestamp without time zone,
    updated_by character varying(100) COLLATE pg_catalog."default",
    project_code character varying(255) COLLATE pg_catalog."default",
    project_name character varying(300) COLLATE pg_catalog."default",
    manager_user_id bigint,
    project_title character varying(300) COLLATE pg_catalog."default",
    CONSTRAINT project_pkey PRIMARY KEY (id),
    CONSTRAINT uk_pyadn2e3xipo328gs8ae6sh11 UNIQUE (project_code)
,
    CONSTRAINT fknfyth6vjm6xb98pnyae22tntw FOREIGN KEY (manager_user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.issue
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(100) COLLATE pg_catalog."default",
    status boolean,
    updated_at timestamp without time zone,
    updated_by character varying(100) COLLATE pg_catalog."default",
    date timestamp without time zone,
    description character varying(1000) COLLATE pg_catalog."default",
    details character varying(4000) COLLATE pg_catalog."default",
    issue_status character varying(255) COLLATE pg_catalog."default",
    assignee_user_id bigint,
    project_id bigint,
    CONSTRAINT issue_pkey PRIMARY KEY (id),
    CONSTRAINT fkcombytcpeogaqi2012phvvvhy FOREIGN KEY (project_id)
        REFERENCES public.project (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqp9x3ntg1rnqgy83tyolxhpt0 FOREIGN KEY (assignee_user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.issue_history
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    created_by character varying(100) COLLATE pg_catalog."default",
    status boolean,
    updated_at timestamp without time zone,
    updated_by character varying(100) COLLATE pg_catalog."default",
    date timestamp without time zone,
    description character varying(1000) COLLATE pg_catalog."default",
    details character varying(4000) COLLATE pg_catalog."default",
    issue_status character varying(255) COLLATE pg_catalog."default",
    assignee_user_id bigint,
    issue_id bigint,
    CONSTRAINT issue_history_pkey PRIMARY KEY (id),
    CONSTRAINT fkfwp9clg9ue9j4fekduna3kx5x FOREIGN KEY (assignee_user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknh1eyx18sao8i4rl7gk87aerd FOREIGN KEY (issue_id)
        REFERENCES public.issue (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
``` 