package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class FilmControllerTest {
    private FilmController filmController;
    private Film film;

    @BeforeEach
    void beforeEach() {
        filmController = new FilmController(new FilmService(new HashMap<>()));
        film = buildFilm(1, "FilmName", "FilmDescription",
                LocalDate.of(2020, 10, 12), 120);
    }

    @Test
    void shouldAddFilm() {
        filmController.addFilm(film);
        assertEquals(1, filmController.findAllFilms().size());
    }

    @Test
    void shouldUpdateFilm() {
        Film film2 = buildFilm(1, "FilmName", "FilmNewDescription",
                LocalDate.of(2020, 10, 12), 130);

        filmController.addFilm(film);
        filmController.updateFilm(film2);
        List<Film> filmList = new ArrayList<>();
        filmList.addAll(filmController.findAllFilms());
        assertEquals("FilmNewDescription", filmList.get(0).getDescription());
    }

    @Test
    void shouldGetAllFilms() {
        Film film2 = buildFilm(2, "NewFilmName", "Film2Description",
                LocalDate.of(2020, 10, 12), 130);

        filmController.addFilm(film2);
        filmController.addFilm(film);
        assertEquals(2, filmController.findAllFilms().size());
    }

    @Test
    void shouldThrowExceptionThenAddEmptyName() {
        Film film2 = buildFilm(2, "", "Film2Description",
                LocalDate.of(2020, 10, 12), 130);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmController.addFilm(film2));
        assertEquals(exception.getMessage(), exception.getMessage());
        assertEquals(0, filmController.findAllFilms().size());
    }

    @Test
    void shouldTrowExceptionThenAddTooLongDescription() {
        Film film2 = buildFilm(2, "Film2Name", "В этом описании более 200 символов, " +
                "по этой причине создание объекта с полем film.description не пройдет валидацию контроллера. " +
                "В поле необходимо указать описание фильма, не превышающим количество символов, равное 200.",
                LocalDate.of(2020, 10, 12), 130);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmController.addFilm(film2));
        assertEquals(exception.getMessage(), exception.getMessage());
        assertEquals(0, filmController.findAllFilms().size());
    }

    @Test
    void shouldThrowExceptionThenAddTooEarlierDateRelease() {
        Film film2 = buildFilm(2, "Film2Name", "Film2Description", LocalDate.of(1890, 10,
                12), 130);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmController.addFilm(film2));
        assertEquals(exception.getMessage(), exception.getMessage());
        assertEquals(0, filmController.findAllFilms().size());
    }

    @Test
    void shouldThrowExceptionThenAddNegativeDuration() {
        Film film2 = buildFilm(2, "Film2Name", "Film2Description", LocalDate.of(1990, 10,
                12), -1);

        ValidationException exception = assertThrows(ValidationException.class, () -> filmController.addFilm(film2));
        assertEquals(exception.getMessage(), exception.getMessage());
        assertEquals(0, filmController.findAllFilms().size());
    }

    private Film buildFilm(int id, String name, String description, LocalDate releaseDate, long duration) {

        return Film.builder()
                .id(id)
                .name(name)
                .description(description)
                .releaseDate(releaseDate)
                .duration(duration)
                .build();
    }
}