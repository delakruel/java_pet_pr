package ru.pcs.web.services;

import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.User;

public interface MainService {
	void addUser(UserForm form);
	User getUser(Integer userId);
	void deleteUser(Integer userId);
	void updateUser(Integer userId, UserForm userForm);
	public void addFilmToUser(Integer userId, Integer FilmId);
}