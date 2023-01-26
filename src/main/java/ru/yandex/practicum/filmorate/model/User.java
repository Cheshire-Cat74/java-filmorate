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
public class User {

    int id;
    String email;
    String login;
    String name;
    LocalDate birthday;
}
