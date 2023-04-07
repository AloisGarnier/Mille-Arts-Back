INSERT INTO `customer` (`id`, `first_name`, `last_name`, `login`, `password`) VALUES (1, 'Alphonse', 'A', 'a', '$2a$12$3JTBArXzpWe4dMCa24mW0.was8rxVPwLxiUzfi7TIbDXDq5aQgJee');
INSERT INTO `customer` (`id`, `first_name`, `last_name`, `login`, `password`) VALUES (2, 'Bertrand', 'B', 'b', '$2a$12$O79ml9omcHMQFhTnoxtrDu831uLzsMcU3GZTzxjlQ1rCJjMkVDZay');

INSERT INTO `city` (`id`, `name`, `zip_code`) VALUES (1, 'Paris', '75000');
INSERT INTO `city` (`id`, `name`, `zip_code`) VALUES (2, 'Lyon', '69000');

INSERT INTO `address` (`id`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (1, 'rue des Acacias', '23', 1, 1);
INSERT INTO `address` (`id`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (2, 'rue des Bleuets', '3bis', 2, 1);
INSERT INTO `address` (`id`, `street`, `street_number`, `customer_id`, `city_id`) VALUES (3, 'rue des Lilas', '127', 2, 2);

INSERT INTO `decoration` (`id`, `name`, `picture`) VALUES (1, 'Chauve-souris', 'https://i.pinimg.com/564x/3e/1e/07/3e1e07ef7dfe787049fff063d7b12684.jpg');
INSERT INTO `decoration` (`id`, `name`, `picture`) VALUES (2, 'Chauve-souris 2', 'https://i.pinimg.com/564x/3e/1e/07/3e1e07ef7dfe787049fff063d7b12684.jpg');

INSERT INTO `tag` (`id`, `name`) VALUES (1, 'Halloween');
INSERT INTO `tag` (`id`, `name`) VALUES (2, 'Violet');
INSERT INTO `tag` (`id`, `name`) VALUES (3, 'Rouge');

INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (1, 1, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (2, 2, 1);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (3, 1, 2);
INSERT INTO `decoration_tag` (`id`, `decoration_id`, `tag_id`) VALUES (4, 2, 3);

INSERT INTO `price` (`id`, `amount`) VALUES (1, 10);
INSERT INTO `price` (`id`, `amount`) VALUES (2, 11);
INSERT INTO `price` (`id`, `amount`) VALUES (3, 12);

INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (1, 1, 1, '2017-11-16', '2017-11-16');
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (2, 2, 1, '2017-11-16', '2017-11-16');
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (3, 1, 2, '2017-11-16', null);
INSERT INTO `decoration_price` (`id`, `decoration_id`, `price_id`, `addition_date`, `withdrawal_date`) VALUES (4, 2, 3, '2017-11-16', null);