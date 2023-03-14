package ru.yandex.practicum.filmorate.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {
    public static int newId = 0;
    long id;
    String name;
    String description;
    LocalDate releaseDate;
    Long duration;
    Set<Long> likes = new HashSet<>();
    int rate;
    Mpa mpa;
    Set<Genre> genres = new HashSet<>();


}