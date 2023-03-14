package ru.yandex.practicum.filmorate.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Genre implements Comparable<Genre> {
    long id;
    String name;

    @Override
    public int compareTo(Genre genre) {
        return (int)(id-genre.getId());
    }
}
