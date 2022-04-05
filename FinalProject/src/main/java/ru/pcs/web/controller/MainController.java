package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.pcs.web.models.Film;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.FilmsRepository;
import ru.pcs.web.repositories.UsersRepository;

import java.util.List;

@Controller
public class MainController {

	@Autowired
	private FilmsRepository filmsRepository;
	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/cinema")
	public String getHomePage(Model model) {
		List<Film> films = filmsRepository.findAll();
		model.addAttribute("films", films);
		return "cinema";
	}
	@PostMapping("/cinema")
	public String toUserPage(@RequestParam("userId") Integer userId) {
		if (userId == 0)
			return "redirect:/cinema/admin";
		return "redirect:/cinema/user/" + userId;
	}
	@GetMapping("/cinema/admin")
	public String getAdminPage(Model model, Model model2) {
		List<User> users = usersRepository.findAll();
		model.addAttribute("users", users);
		List<Film> films = filmsRepository.findAll();
		model2.addAttribute("films", films);
		return "cinema/admin";
	}
}
