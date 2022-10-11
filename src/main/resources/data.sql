DROP TABLE IF EXISTS smartphones;

CREATE TABLE smartphones (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	brand VARCHAR(250),
	model VARCHAR(250),
	details VARCHAR(250),
	released DATE
);

INSERT INTO smartphones (brand, model, details, released) VALUES ('Apple', 'iPhone SE 5G 2022 3rd gen A2784 Dual SIM TD-LTE RU KZ 256GB', 'From livestreaming to multiplayer gaming to video sharing, 5G really speeds things up. Top iPhone SE 2022 variant with 4 / 256 GB memory for Russia, Armenia, Belarus, Kazakhstan and Kyrgyzstan', '2022-03-08');
INSERT INTO smartphones (brand, model, details, released) VALUES ('Xiaomi', 'Redmi K50 Gaming 5G Standard Edition Dual SIM TD-LTE 128GB 21121210C / K50G', 'The 6.67-inch AMOLED display has been specially designed for gaming, with optimal colour accuracy, brightness and feel. The most affordable Chinese variant of Redmi K50G gamer smartphone with 8 / 128 GB memory', '2022-02-01');
INSERT INTO smartphones (brand, model, details, released) VALUES ('Samsung', 'SM-E236B/DS Galaxy F23 5G 2022 Standard Edition Dual SIM TD-LTE IN 128GB', 'Incorporating a Power Cool technology, it helps to keep your phone cool even when you are engaged to binge gaming sessions for extended hours', '2022-03-08');
INSERT INTO smartphones (brand, model, details, released) VALUES ('Samsung', 'SM-A600F/DS Galaxy A6 2018 Duos Global TD-LTE 64GB', '', '2022-07-08');
INSERT INTO smartphones (brand, model, details, released) VALUES ('Sony', 'Xperia 10 IV 5G Dual SIM TD-LTE JP 128GB XQ-CC44', 'Japanese dual SIM variant of Xperia 10 Mark 4 mid-ranger with 6-inch notchless AMOLED screen, 6 GiB of RAM, 128 GB flash memory', '2022-07-08');
