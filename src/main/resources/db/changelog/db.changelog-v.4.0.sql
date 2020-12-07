--liquibase formatted sql
--changeset nazarova:4

 create function Create_view() returns boolean
   language plpgsql
   as
 $$
    begin
      drop view if exists actual_products_view;
      create or replace view actual_products_view
      as
       select
         name_product,
         purchase_price + purchase_price * markup / 100 as "price_one",
         (purchase_price * markup / 100.0 * number) as "revenue",
         (purchase_price * markup / 100.0 * number) * 0.8 as "profit"
       from   public."Products"
     where shelf_life >=7;
    RETURN true;
   end;
 $$;

