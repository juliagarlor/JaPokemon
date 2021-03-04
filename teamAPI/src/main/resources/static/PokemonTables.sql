DROP SCHEMA IF EXISTS pokemon_test;
CREATE SCHEMA pokemon_test;
DROP SCHEMA IF EXISTS pokemon;
CREATE SCHEMA pokemon;
USE pokemon;

CREATE TABLE pokemon(
id BIGINT NOT NULL AUTO_INCREMENT,
pokedex_id BIGINT,
PRIMARY KEY(id)
);

CREATE TABLE trainer(
id BIGINT NOT NULL AUTO_INCREMENT,
name VARCHAR(255),
age INT,
hobby VARCHAR(255),
photo VARCHAR(255),
PRIMARY KEY(id)
);

CREATE TABLE team(
team_id BIGINT NOT NULL AUTO_INCREMENT,
trainer_id BIGINT,
PRIMARY KEY(team_id),
FOREIGN KEY(trainer_id) REFERENCES trainer(id)
);

CREATE TABLE pokemon_in_team(
team_id BIGINT,
pokemon_id BIGINT,
FOREIGN KEY(team_id) REFERENCES team(team_id),
FOREIGN KEY(pokemon_id) REFERENCES pokemon(id)
);

INSERT INTO trainer(name, age, hobby,  photo) VALUES
('Aliany', 35,'ver Pokemon (para dejar de escribir Poquemon y Picachu)', 'aliany.png'),
('Carolina', 24,'borrar tatuajes', 'carolina.png'),
('Antonio', 32,'recomendar series', 'antonio.png'),
('Rubén', 34, 'comprar y resolver cubos de rubik', 'ruben.png'),
('Julia', 25,'vaguear', 'julia.png');

INSERT INTO pokemon(pokedex_id) VALUES
-- magikarp, 1
(129),
-- kadabra, 2
(64),
-- articuno, 3
(144),
-- charizard, 4
(6),
-- zapdos, 5
(145),
-- gyarados, 6
(130),
-- farfetch'd, 7
(83),
-- dugtrio, 8
(51),

-- charmander, 9
(4),
-- pikachu, 10
(25),
-- ninetales, 11
(38),
-- psyduck, 12
(54),
-- ekans, 13
(23),
-- nidoran, 14
(29),

-- chandelure, 15
(609),
-- rotom, 16
(479),
-- honchcrow, 17
(430),
-- banette, 17
(354),
-- drifloon, 19
(425),
-- umbreon, 20
(197),

-- ditto, 21
(132),
-- meowth, 22
(52),
-- snorlax, 23
(143),
-- bulbasur, 24
(1),
-- magneton, 25
(82),
-- mew, 26
(151),
-- haunter, 27
(93)
;

INSERT INTO team(trainer_id) VALUES
(1),
(2),
(3),
(4),
(5);

INSERT INTO pokemon_in_team(team_id, pokemon_id) VALUES
-- Aliany
(1, 1),
(1, 9),
(1, 21),
(1, 15),
-- Carolina
(2, 9),
(2, 10),
(2, 11),
(2, 12),
(2, 13),
(2, 14),
-- Antonio
(3, 21),
(3, 22),
(3, 23),
(3, 24),
(3, 25),
(3, 26),
(3, 27),
-- Rubén
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(4, 6),
(4, 7),
(4, 8),
-- julia
(5, 15),
(5, 16),
(5, 17),
(5, 18),
(5, 19),
(5, 20)
;