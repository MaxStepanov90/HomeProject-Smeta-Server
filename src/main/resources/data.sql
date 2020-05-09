insert into PAYMENT (amount, comment, date, estimate_name, estimate_id, project_id)
values (20000, 'аванс за стены', '2010-03-03', 'Черновые работы', 1, 1),
       (40000, ' оплата за штукатурку', '2010-03-10', 'Черновые работы', 1, 1),
       (10000, 'аванс за электрику', '2010-03-17', 'Электрика', 2, 1);

insert into MARK_UP (mark_up_name, mark_up_percent)
values ('материалы', 10.0),
       ('работы', 20.0);

insert into PROJECT
values (1, 'Сухановская д.21 кв.3', '№1', '2010-03-03', 'Ремонт квартиры 40м2 под ключ', 'ЖК Савеловский',
        'Степанов М.Э.'),
       (2, 'Динамовская д.15 кв.30', '№2', '2011-10-03', 'Ремонт квартиры 100м2 под ключ', 'ЖК Динамо',
        'Соколов Г.Э.'),
       (3, 'Скобелевская д.1 кв.45', '№3', '2012-10-10', 'Ремонт квартиры 46м2 под ключ', 'ЖК Садовый',
        'Иванов К.К.'),
       (4, 'Комаровская д.10 кв.8', '№4', '2013-05-06', 'Ремонт квартиры 60м2 под ключ', 'ЖК Комарово',
        'Соколов Т.А.'),
       (5, 'Туполевская д.3 кв.300', '№5', '2014-09-09', 'Ремонт квартиры 72м2 под ключ', 'ЖК Туполево',
        'Сорокин Д.В.'),
       (6, 'Барышевая д.210 кв.354', '№6', '2015-11-06', 'Ремонт квартиры 25м2 под ключ', 'ЖК Барышево',
        'Булкин В.В.'),
       (7, 'Черемушкинская д.98 кв.38', '№7', '2016-02-03', 'Ремонт квартиры 33м2 под ключ', 'ЖК Черемушки',
        'Клюкин М.Р.'),
       (8, 'Гоголевская д.56 кв.334', '№8', '2017-08-03', 'Ремонт квартиры 55м2 под ключ', 'ЖК Гоголь',
        'Нарышкин Л.В.'),
       (9, 'Балашихинская д.210 кв.367', '№9', '2018-03-03', 'Ремонт квартиры 40м2 под ключ', 'ЖК Балашиха',
        'Ложкин Р.Э.'),
       (10, 'Домодедовская д.86 кв.49', '№10', '2019-07-03', 'Ремонт квартиры 40м2 под ключ', 'ЖК Домодедово',
        'Щукин В.К.');

insert into ESTIMATE
values (1, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 1),
       (2, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 1),
       (3, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 1),
       (4, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 1),
       (5, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 1),

       (6, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 2),
       (7, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 2),
       (8, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 2),
       (9, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 2),
       (10, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 2),

       (11, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 3),
       (12, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 3),
       (13, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 3),
       (14, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 3),
       (15, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 3),

       (16, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 4),
       (17, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 4),
       (18, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 4),
       (19, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 4),
       (20, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 4),

       (21, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 5),
       (22, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 5),
       (23, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 5),
       (24, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 5),
       (25, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 5),

       (26, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 6),
       (27, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 6),
       (28, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 6),
       (29, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 6),
       (30, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 6),

       (31, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 7),
       (32, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 7),
       (33, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 7),
       (34, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 7),
       (35, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 7),

       (36, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 8),
       (37, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 8),
       (38, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 8),
       (39, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 8),
       (40, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 8),

       (41, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 9),
       (42, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 9),
       (43, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 9),
       (44, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 9),
       (45, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 9),

       (46, 60000.0, 'Черновые работы', 60000.0, 60000.0, 100.0, 10),
       (47, 30000.0, 'Электрика', 30000.0, 30000.0, 100.0, 10),
       (48, 30000.0, 'Сантехника', 5000.0, 25000.0, 10.0, 10),
       (49, 40000.0, 'Предчистовые работы', 25000.0, 15000.0, 60.0, 10),
       (50, 40000.0, 'Чистовые работы', 10000.0, 30000.0, 10.0, 10);


insert into ESTIMATE_DETAIL (category, complete, cost, cost_client,
                             name, price, price_client,
                             quantity, unit, estimate_id)
values ('работы', true, 3000.0, 3600.0, 'Грунтовка стен', 30.0, 36.0, 100.0, 'м2', 1),
       ('материалы', false, 1400, 1540, 'Грунтовка Ceresit', 2, 2.4, 700, 'м2', 1),
       ('работы', true, 40000.0, 48000.0, 'Штукатурка стен', 400.0, 480.0, 100.0, 'м2', 1),
       ('материалы', false, 21600, 23700, 'Штукатурка Волма-слой', 400.0, 440.0, 54, 'м2', 1),
       ('работы', true, 15000.0, 18000.0, 'Электроточки', 500.0, 550.0, 30.0, 'шт', 2),
       ('материалы', false, 165.0, 181.5, 'Подрозетники', 5.5, 6.05, 30.0, 'шт', 2),
       ('работы', false, 15000.0, 18000.0, 'Сантехника', 500.0, 600.0, 30.0, 'шт', 3),
       ('работы', true, 3000.0, 3600.0, 'Грунтовка стен', 30.0, 36.0, 100.0, 'м2', 4),
       ('работы', false, 25000.0, 30000.0, 'Шпаклевка стен', 250.0, 300.0, 100.0, 'м2', 4);


-- alter sequence hibernate_sequence restart with 3;

--        (7, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (8, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (9, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (10, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (11, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (12, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (13, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (14, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (15, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (16, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (17, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (18, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (19, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (20, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (21, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (22, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (23, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (24, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (25, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (26, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (27, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (28, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (29, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (30, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (31, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (32, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (33, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (34, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (35, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (36, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (37, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (38, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (39, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (40, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (41, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (42, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (43, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (44, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (45, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (46, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (47, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (48, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (49, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (50, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (51, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (52, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (53, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (54, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (55, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (56, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (57, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (58, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (59, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (60, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2'),
--
--        (61, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (62, 40000.0, 1.5, 'Штукатурка стен', 400.0, 100.0,'м2'),
--        (63, 15000.0, 1.5, 'Электроточки', 500.0, 30.0,'шт'),
--        (64, 15000.0, 1.5, 'Сантехника', 500.0, 30.0,'шт'),
--        (65, 3000.0, 1.5, 'Грунтовка стен', 30.0, 100.0,'м2'),
--        (66, 25000.0, 1.5, 'Шпаклевка стен', 250.0, 100.0,'м2');