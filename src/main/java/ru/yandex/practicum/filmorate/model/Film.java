package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Data
@Builder
public class Film {

    public static final LocalDate EARLIEST_DATE_OF_RELEASE = LocalDate.of(1895, 12, 28);
    public static final int MAX_LENGTH_OF_DESCRIPTION = 200;

    private int id;
    private String name;
    @Size(max = 200)
    private String description;
    private LocalDate releaseDate;
    private long duration;

    /*public Film(int filmId, String name, String description, LocalDate releaseDate, Integer duration) {
        this.filmId = filmId;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }*/
}
