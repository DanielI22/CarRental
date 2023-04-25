create table if not exists car
(
	car_id bigint auto_increment
		primary key,
	daily_rate double null,
	vin_number varchar(255) null
);

create table if not exists extra
(
	extra_id bigint auto_increment
		primary key,
	name varchar(255) null,
	price double null
);

create table if not exists rental
(
	rental_id bigint auto_increment
		primary key,
	car_id bigint null,
	customer_email varchar(255) null,
	end_date date null,
	price double null,
	start_date date null,
	constraint FKqoq449d7f5x3a9as634tj4l4b
		foreign key (car_id) references car (car_id)
);

create table if not exists rental_extra
(
	rental_id bigint not null,
	extra_id bigint not null,
	primary key (rental_id, extra_id),
	constraint FKddqc6ckn0hetmyw9uksmwjojl
		foreign key (rental_id) references rental (rental_id),
	constraint FKj31ydup99qll4bycb144dmy9j
		foreign key (extra_id) references extra (extra_id)
);

   alter table car
       add column image_url varchar(9000)