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
hobby VARCHAR(255),
`name` VARCHAR(255),
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

INSERT INTO trainer(hobby, `name`, photo) VALUES
('ver Pokemon', 'Aliany', 'aliany.png'),
('borrar tatuajes', 'Carolina', 'carolina.png'),
('recomendar series', 'Antonio', 'antonio.png'),
('comprar y resolver cubos de rubik', 'Rubén', 'ruben.png');

INSERT INTO pokemon(pokedex_id) VALUES
(129),
(129),
(129),
(129),
(129),
(129),
(129)
;

INSERT INTO team(trainer_id) VALUES
(1),
(2),
(3),
(4);

INSERT INTO pokemon_in_team(team_id, pokemon_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(4, 6),
(4, 7);
