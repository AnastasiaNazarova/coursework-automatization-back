--liquibase formatted sql
--changeset nazarova:4:insert-table-staff

INSERT INTO staff VALUES (nextval('staff_seq'),'Крылья','17.02.01');
INSERT INTO staff VALUES (nextval('staff_seq'),'Горизонт','21.05.02');
INSERT INTO staff VALUES (nextval('staff_seq'),'Космос','05.03.01');


--changeset nazarova:5:insert-table-group

INSERT INTO "group" VALUES (nextval('group_seq'),'Легенда','10.02.07',1);
INSERT INTO "group" VALUES (nextval('group_seq'),'Комета','10.01.07',1);
INSERT INTO "group" VALUES (nextval('group_seq'),'Солнце','19.05.02',3);
INSERT INTO "group" VALUES (nextval('group_seq'),'Группа ребят','28.02.02',2);

--changeset nazarova:6:insert-table-member-rso
INSERT INTO member_rso VALUES (nextval('member_rso_seq'), 'Ниязова Александра Вадимовна', '13.01.2000', 1,'боец','2017');
INSERT INTO member_rso VALUES (nextval('member_rso_seq'), 'Питерский Андрей Иванович', '14.03.1999', 2,'мастер','2015');
INSERT INTO member_rso VALUES (nextval('member_rso_seq'), 'Варварская Ута Сергеевна', '05.04.1998',3,'командир','2015');
INSERT INTO member_rso VALUES (nextval('member_rso_seq'), 'Мышкина Анна Львовна', '17.05.2001', 4,'боец','2019');
INSERT INTO member_rso VALUES (nextval('member_rso_seq'), 'Бузлов Димитрий Нуфагович', '22.01.2001', 2,'боец','2017');
