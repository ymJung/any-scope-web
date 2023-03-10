insert into point (point, user_id) values (10000, 0);
insert into menu (name, price) values ('americano', 100),('latte', 200),('milk', 50),('green tea', 100),('red tea', 150);
insert into order_info (menu_id, user_id, order_time) values
    (1, 0, CURRENT_TIMESTAMP()),(1, 0, CURRENT_TIMESTAMP()),(1, 0, CURRENT_TIMESTAMP()),(1, 0, CURRENT_TIMESTAMP()),(1, 0, CURRENT_TIMESTAMP()),
    (2, 0, CURRENT_TIMESTAMP()),(2, 0, CURRENT_TIMESTAMP()),(2, 0, CURRENT_TIMESTAMP()),(2, 0, CURRENT_TIMESTAMP()),
    (3, 0, CURRENT_TIMESTAMP()),(3, 0, CURRENT_TIMESTAMP()),(3, 0, CURRENT_TIMESTAMP()),
    (4, 0, CURRENT_TIMESTAMP()),(4, 0, CURRENT_TIMESTAMP()),
    (5, 0, CURRENT_TIMESTAMP())
;
