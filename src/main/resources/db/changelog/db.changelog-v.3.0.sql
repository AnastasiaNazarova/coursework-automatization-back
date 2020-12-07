--liquibase formatted sql
--changeset nazarova:3
insert into  public."products"  values (1,'Колбаса', 100, 10,12,5,' ');
insert into  public."products"  values (2,'Мясо', 200, 3,10,12,' ');
insert into  public."products"  values (3,'Молоко', 80, 15,20,3,' ');
insert into  public."products"  values (4,'Масло', 130, 12,15,15,' ');
insert into  public."products"  values (5,'Хлеб', 20, 20,5,5,' ');

insert into  public."products"  values (6,'Шоколад', 100, 10,12,120,' ');
insert into public."products"  values (7,'Халва', 200, 3,10,365,' ');
insert into  public."products"  values (8,'Морс', 80, 15,20,28,' ');
insert into  public."products"  values (9,'Мармелад', 130, 12,15,45,' ');
insert into  public."products"  values (10,'Печенье', 20, 20,5,1250,' ');

insert into  public."products"  values (11,'Сок', 100, 10,12,35,' ');
insert into  public."products"  values (12,'Квас', 200, 3,10,45,' ');
insert into  public."products"  values (13,'Лимонад', 80, 15,20,50,' ');
insert into  public."products"  values (14,'Ряженка', 130, 12,15,20,' ');
insert into  public."products"  values (15,'Компот', 20, 20,5,1,' ');

insert into  public."products"  values (16,'Помидор', 100, 10,12,10,'желтые');
insert into  public."products"  values (17,'Огурец', 200, 3,10,9,' ');
insert into  public."products"  values (18,'Арбуз', 80, 15,20,21,'краснодарский');
insert into  public."products"  values (19,'Дыня', 130, 12,15,22,' ');
insert into  public."products"  values (20,'Яблоко', 20, 20,5,30,'зеленое');