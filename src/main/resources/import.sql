INSERT INTO `customer` (`id`, `first_name`, `last_name`, `login`, `password`, `description`) VALUES (1, 'Admin', '', 'admin', '$2a$10$MpHUhbZbl9CGoBdWzOk0dOMKw0xVZo2wdg9s2Ym7.geEyIFoQ599m', 'test');

INSERT INTO `customer` (`id`, `first_name`, `last_name`, `login`, `password`) VALUES (2, 'Alphonse', 'A', 'a@a.a', '$2a$12$3JTBArXzpWe4dMCa24mW0.was8rxVPwLxiUzfi7TIbDXDq5aQgJee');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `login`, `password`) VALUES (3, 'Bertrand', 'B', 'b@b.b', '$2a$12$O79ml9omcHMQFhTnoxtrDu831uLzsMcU3GZTzxjlQ1rCJjMkVDZay');

INSERT INTO `city` (`id`, `name`, `zip_code`) VALUES (1, 'Paris', '75000');
INSERT INTO `city` (`id`, `name`, `zip_code`) VALUES (2, 'Lyon', '69000');

INSERT INTO `address` (`id`, `name`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (1, 'Maison', 'rue des Acacias', '23', 2, 1);
INSERT INTO `address` (`id`, `name`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (2, 'Maison', 'rue des Bleuets', '3bis', 3, 1);
INSERT INTO `address` (`id`, `name`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (3, 'Chez Mamie', 'rue des Lilas', '127', 3, 2);

INSERT INTO `decoration` (`id`, `name`, `description`, `addition_date`) VALUES (1, 'Maison enneigée', 'Maisonnette enneigée et décorée, d''environ 20 cm de haut, se fondant parfaitement dans un décor de Noël', '2023-05-26');
INSERT INTO `decoration` (`id`, `name`, `description`, `addition_date`) VALUES (2, 'Sac en tissu', 'Joli sac en tissu accompagné de 3 sucres d''orge décoratifs', '2023-05-27');
INSERT INTO `decoration` (`id`, `name`, `description`, `addition_date`) VALUES (3, 'Champignon de Noël', 'Champignon de Noël vendu à l''unité', '2023-05-28');
INSERT INTO `decoration` (`id`, `name`, `description`, `addition_date`) VALUES (4, 'Sac en tissu', 'Petit sac en tissu vendu à l''unité', '2023-05-29');
INSERT INTO `decoration` (`id`, `name`, `description`, `addition_date`) VALUES (5, 'Bonhomme de neige', 'Magnifique bonhomme de neige d''environ 10 cm de haut', '2023-05-30');

INSERT INTO `picture` (`id`, `path`, `decoration_id`) VALUES (1, 'https://i.pinimg.com/750x/d4/ce/52/d4ce5208d8b912a89ea66c0f3f34c2ba.jpg', 1);
INSERT INTO `picture` (`id`, `path`, `decoration_id`) VALUES (2, 'https://i.pinimg.com/750x/a2/8b/c1/a28bc1d38f92160937ba6296f435ca36.jpg', 2);
INSERT INTO `picture` (`id`, `path`, `decoration_id`) VALUES (3, 'https://i.pinimg.com/750x/42/72/9c/42729ce3a61105c4a75486f850206f75.jpg', 3);
INSERT INTO `picture` (`id`, `path`, `decoration_id`) VALUES (4, 'https://i.pinimg.com/750x/74/46/d6/7446d611844ad153a50f267d06006389.jpg', 4);
INSERT INTO `picture` (`id`, `path`, `decoration_id`) VALUES (5, 'https://i.pinimg.com/750x/7c/a6/e7/7ca6e70767cde4b87ed6fc516995dab4.jpg', 5);


INSERT INTO `tag` (`id`, `name`) VALUES (1, 'Noël');
INSERT INTO `tag` (`id`, `name`) VALUES (2, 'Maison');
INSERT INTO `tag` (`id`, `name`) VALUES (3, 'Sac');
INSERT INTO `tag` (`id`, `name`) VALUES (4, 'Champignon');
INSERT INTO `tag` (`id`, `name`) VALUES (5, 'Bonhomme de neige');

INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (1, 1, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (2, 2, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (3, 3, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (4, 4, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (5, 5, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (6, 1, 2);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (7, 2, 3);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (8, 3, 4);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (9, 4, 3);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (10, 5, 5);

INSERT INTO `price` (`id`, `amount`) VALUES (1, 20);
INSERT INTO `price` (`id`, `amount`) VALUES (2, 15);
INSERT INTO `price` (`id`, `amount`) VALUES (3, 12.5);
INSERT INTO `price` (`id`, `amount`) VALUES (4, 10);

INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (1, 1, 1, '2023-05-26', null);
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (2, 2, 2, '2023-05-26', null);
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (3, 3, 3, '2023-05-26', null);
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (4, 4, 4, '2023-05-26', null);
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (5, 5, 2, '2023-05-26', null);

INSERT INTO `command` (`id`, `customer_id`, `order_date`) VALUES (1, 2, '2023-03-12');
INSERT INTO `command` (`id`, `customer_id`, `order_date`) VALUES (2, 2, '2023-01-02');
INSERT INTO `command` (`id`, `customer_id`, `order_date`) VALUES (3, 2, '2023-02-27');

INSERT INTO `command_line` (`id`, `command_id`, `decoration_id`,  `quantity`) VALUES (1, 1, 1, 3);
INSERT INTO `command_line` (`id`, `command_id`, `decoration_id`,  `quantity`) VALUES (2, 1, 2, 2);
INSERT INTO `command_line` (`id`, `command_id`, `decoration_id`,  `quantity`) VALUES (3, 2, 1, 1);
INSERT INTO `command_line` (`id`, `command_id`, `decoration_id`,  `quantity`) VALUES (4, 3, 2, 1);
