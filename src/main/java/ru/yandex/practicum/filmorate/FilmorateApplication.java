package ru.yandex.practicum.filmorate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FilmorateApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmorateApplication.class, args);
		/*Film film1 = Film.builder()
				.filmId(1)
				.name("Alice in Wonderland")
				.description("fantasy adventure film directed by Tim Burton and written by Linda Woolverton")
				.releaseDate(LocalDate.of(2010, 2, 25))
				.duration(109L)
				.build();

		FilmValidator filmValidator = new FilmValidator();
		filmValidator.addFilm(film1);

		User user1 = User.builder((1) "vicka.cheshirecat@gmail.com", "Cheshire", "Viktoria",
				LocalDate.of(1999,3,2));
		UserValidator userValidator = new UserValidator();
		userValidator.createUser(user1);*/
	}
}
