package ru.yandex.practicum.filmorate.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {

    public static final LocalDate EARLIEST_DATE_OF_RELEASE = LocalDate.of(1895, 12, 28);
    public static final int MAX_LENGTH_OF_DESCRIPTION = 200;

    int id;
    String name;
    String description;
    LocalDate releaseDate;
    long duration;

}
