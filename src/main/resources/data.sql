insert into PAYMENT (id,amount, category, comment, date, estimate_name, estimate_id, project_id)
values (1, 10000, 'работы', 'аванс за стены', '2010-03-03', 'Черновые работы', 1, 1),
       (2,5000, 'материалы', ' оплата за штукатурку', '2010-03-10', 'Черновые работы', 1, 1),
       (3,5000, 'работы', ' аванс за электрику', '2010-03-10', 'Электрика', 2, 1),
       (4,181.5, 'материалы', ' оплата за подрозетники', '2010-03-10', 'Электрика', 2, 1);

insert into MARK_UP (id,mark_up_name, mark_up_percent)
values (1,'материалы', 10.0),
       (2,'работы', 20.0);
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
values (1, 76840.0, 'Черновые работы',12300, 15000, 27300, 1),
       (2, 18181.5, 'Электрика', -5000, 5181.5, 181.5, 1);


insert into ESTIMATE_DETAIL (id,category, complete, cost, cost_client,
                             name, price, price_client,
                             quantity, unit, estimate_id)
values (1,'работы', true, 3000.0, 3600.0, 'Грунтовка стен', 30.0, 36.0, 100.0, 'м2', 1),
       (2,'материалы', false, 1400, 1540, 'Грунтовка Ceresit', 2, 2.4, 700, 'м2', 1),
       (3,'работы', false, 40000.0, 48000.0, 'Штукатурка стен', 400.0, 480.0, 100.0, 'м2', 1),
       (4,'материалы', true, 21600, 23700, 'Штукатурка Волма-слой', 400.0, 440.0, 54, 'м2', 1),
       (5,'работы', false, 15000.0, 18000.0, 'Электроточки', 500.0, 550.0, 30.0, 'шт', 2),
       (6,'материалы', true, 165.0, 181.5, 'Подрозетники', 5.5, 6.05, 30.0, 'шт', 2);
