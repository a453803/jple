# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table visitor (
  id                        integer auto_increment not null,
  adjective                 varchar(255),
  noun                      varchar(255),
  constraint pk_visitor primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table visitor;

SET FOREIGN_KEY_CHECKS=1;

