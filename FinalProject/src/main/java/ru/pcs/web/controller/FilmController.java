package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.pcs.web.forms.FilmForm;
import ru.pcs.web.models.Film;
import ru.pcs.web.services.FilmService;

@RequiredArgsConstructor
@Controller
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping("/cinema/film/{film-id}")
	public String getFilmPage(Model model, @PathVariable("film-id") Integer filmId) {
		Film film = filmService.getFilm(filmId);
		model.addAttribute("film", film);
		return "/cinema/film";
	}
	@PostMapping("/cinema/film/{film-id}/delete")
	public String deleteFilm(@PathVariable("film-id") Integer filmId) {
		filmService.deleteFilm(filmId);
		return "redirect:/cinema/admin";
	}
	@PostMapping("/cinema/film/{film-id}/update")
	public String updateFilm(@PathVariable("film-id") Integer filmId, FilmForm filmForm) {
		filmService.updateFilm(filmId, filmForm);
		return "redirect:/cinema/admin";
	}
	@PostMapping("/cinema/addFilm")
	public String addFilm(FilmForm form) {
		filmService.addFilm(form);
		return "redirect:/cinema/admin";
	}
}