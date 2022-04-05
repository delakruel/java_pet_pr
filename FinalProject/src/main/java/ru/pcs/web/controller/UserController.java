package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.Film;
import ru.pcs.web.models.SeenFilm;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.FilmsRepository;
import ru.pcs.web.repositories.SeenFilmsRepository;
import ru.pcs.web.services.MainService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

	@Autowired
	private MainService mainService;
	@Autowired
	private FilmsRepository filmsRepository;
	@Autowired
	private SeenFilmsRepository seenFilmsRepository;

	@GetMapping("/cinema/user/{user-id}")
	public String getUserPage(Model model, @PathVariable("user-id") Integer userId, Model model2, Model model3) {
		User user = mainService.getUser(userId);
		model.addAttribute("user", user);
		List<Film> films = filmsRepository.findAllByRatingLessThanEqual(user.getChildFilter());
		model2.addAttribute("films", films);
		List<SeenFilm> seenFilms = seenFilmsRepository.findAllByViewer_Id(userId);
		model3.addAttribute("seenFilms", seenFilms);
		return "/cinema/user";
	}
	@PostMapping("/cinema/user/{user-id}/delete")
	public String deleteUser(@PathVariable("user-id") Integer userId) {
		mainService.deleteUser(userId);
		return "redirect:/cinema/admin";
	}
	@PostMapping("/cinema/user/{user-id}/update")
	public String updateUserPage(@PathVariable("user-id") Integer userId, UserForm userForm) {
		mainService.updateUser(userId, userForm);
		return "redirect:/cinema/user/{user-id}";
	}
	@PostMapping("/cinema/addUser")
	public String addUser(UserForm form) {
		mainService.addUser(form);
		return "redirect:/cinema/admin";
	}
	@PostMapping("/cinema/film/{film-id}/watchBy/{user-id}")
	public String watchFilmByUser(@PathVariable("film-id") Integer filmId, @PathVariable("user-id") Integer userId) {
		mainService.addFilmToUser(userId, filmId);
		return "redirect:/cinema/user/{user-id}";
	}

}
