package ru.pcs.web.services;

import ru.pcs.web.forms.FilmForm;
import ru.pcs.web.models.Film;

public interface FilmService {
	Film getFilm(Integer filmId);
	void updateFilm(Integer filmId, FilmForm filmForm);
	void addFilm(FilmForm filmForm);
	void deleteFilm(Integer filmId);
}