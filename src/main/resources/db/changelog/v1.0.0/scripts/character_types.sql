insert into character_type (id, name) values ((select nextval('character_type_seq')),'Good');
insert into character_type (id, name) values ((select nextval('character_type_seq')), 'Evil');
insert into character_type (id, name) values ((select nextval('character_type_seq')), 'Neutral');
