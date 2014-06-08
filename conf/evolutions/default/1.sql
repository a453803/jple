# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table visitor (
  id                        integer not null,
  adjective                 varchar(255),
  noun                      varchar(255),
  constraint pk_visitor primary key (id))
;

create sequence visitor_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists visitor;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists visitor_seq;

