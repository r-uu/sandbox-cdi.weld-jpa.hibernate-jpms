create table item.item_item (id bigint not null, name varchar(255), price numeric(38,2), primary key (id));
create sequence item_item_SEQ start with 1 increment by 50;
create table item.ItemDefault (id bigint not null, name varchar(255), price numeric(38,2), primary key (id));
create sequence ItemDefault_SEQ start with 1 increment by 50;
create table ItemDefault (id bigint not null, name varchar(255), price numeric(38,2), primary key (id));
create sequence ItemDefault_SEQ start with 1 increment by 50;
