CREATE TABLE IF NOT EXISTS mpa
(
    id          INTEGER PRIMARY KEY auto_increment,
    name        VARCHAR(128),
    description VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS films
(
    id          INTEGER PRIMARY KEY auto_increment,
    name        VARCHAR(128),
    description VARCHAR(200),
    releaseDate DATE,
    duration    LONG,
    rate        INTEGER,
    mpaId       INTEGER,
    FOREIGN KEY (mpaId) REFERENCES mpa (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id       INTEGER PRIMARY KEY auto_increment,
    email    VARCHAR(128),
    login    VARCHAR(128),
    name     VARCHAR(128),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS genres
(
    id   INTEGER PRIMARY KEY auto_increment,
    name VARCHAR(128)
);

CREATE TABLE IF NOT EXISTS likes
(
    filmId INTEGER,
    userId INTEGER,
    PRIMARY KEY (filmId, userId),
    FOREIGN KEY (filmId) REFERENCES films (id) ON DELETE CASCADE,
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS friends
(
    userId   INTEGER,
    friendId INTEGER,
    status   BOOLEAN,
    PRIMARY KEY (userId, friendId),
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (friendId) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS filmGenres
(
    filmId  INTEGER,
    genreId INTEGER,
    PRIMARY KEY (filmId, genreId),
    FOREIGN KEY (filmId) REFERENCES films (id) ON DELETE CASCADE,
    FOREIGN KEY (genreId) REFERENCES genres (id) ON DELETE CASCADE
);