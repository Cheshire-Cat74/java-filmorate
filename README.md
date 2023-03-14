# java-filmorate - бэкенд сервиса для работы с фильмами и оценками пользователей.
### Связи между моделями (ER-diagram)

![This is an image](https://sun2.beeline-kz.userapi.com/impg/AoLC2vX9QUhhYktPXKreUJWJ-whzUrDennkdCg/JNBvnBaesp0.jpg?size=2406x1266&quality=96&sign=5c96debf20e5581dcfae9b654f03f8ae&type=album)


### Таблицы
* **films** - фильмы
* **users** - пользователи
* **genres** - жанры
* **film_genres** - жанры, присвоенные фильмам
* **mpa-ratings** - рейтинг, присвоенный MPA
* **film-likes** - информация о лайках пользователей к фильмам
* **user-friends** - информация об отношении дружбы пользователей друг с другом

## Технологии в проекте
* Java v.11.0.16
* Spring Boot
* Postgres
* REST API

**Примеры запросов для основных операций**
* Получение списка всех фильмов
```
SELECT *
FROM films;
```

* Получение 10 наиболее популярных фильмов (id и название) по количеству лайков
```
SELECT film_id,
       name
FROM films
ORDER BY rate DESC
LIMIT 10;
```

* Получение пользователя с id=17
```
SELECT *
FROM users
WHERE user_id=17;
```

* Получение списка друзей (id и login) пользователя с id=17
```
SELECT u.user_id,
       u.login
FROM users u
INNER JOIN friends f ON f.user_id = 17 AND u.user_id = f.friend_id;
```

* Получение списка общих друзей (id и login) пользователей с id=3 и id=17
```
SELECT u.user_id,
       u.login
FROM users u
INNER JOIN friends f ON (f.user_id = 3 AND u.user_id = f.friend_id) AND
                        (f.user_id = 17 AND u.user_id = f.friend_id);
```

