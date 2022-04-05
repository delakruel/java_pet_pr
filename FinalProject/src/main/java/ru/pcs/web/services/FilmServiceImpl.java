package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.FilmForm;
import ru.pcs.web.models.Film;
import ru.pcs.web.repositories.FilmsRepository;

@RequiredArgsConstructor
@Component
public class FilmServiceImpl implements FilmService{

	private final FilmsRepository filmsRepository;
	@Override
	public Film getFilm(Integer filmId) {
		return filmsRepository.getById(filmId);
	}
	@Override
	public void deleteFilm(Integer filmId) {
		filmsRepository.deleteById(filmId);
	}
	@Override
	public void updateFilm(Integer filmId, FilmForm filmForm) {
		Film film = filmsRepository.getById(filmId);
		film.setName(filmForm.getName());
		film.setYear(filmForm.getYear());
		film.setGenre(filmForm.getGenre());
		film.setRating(filmForm.getRating());
		filmsRepository.save(film);
	}
	@Override
	public void addFilm(FilmForm filmForm) {
		Film film = Film.builder()
				.name(filmForm.getName())
				.year(filmForm.getYear())
				.genre(filmForm.getGenre())
				.rating(filmForm.getRating())
				.build();
		filmsRepository.save(film);
	}
}
