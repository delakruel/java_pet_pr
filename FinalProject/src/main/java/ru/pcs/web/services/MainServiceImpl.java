package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.SeenFilm;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.FilmsRepository;
import ru.pcs.web.repositories.SeenFilmsRepository;
import ru.pcs.web.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Component
public class MainServiceImpl implements MainService {
	private final UsersRepository usersRepository;
	private final FilmsRepository filmsRepository;
	private final SeenFilmsRepository seenFilmsRepository;

	@Override
	public void addUser(UserForm form) {
		User user = User.builder()
				.firstName(form.getFirstName())
				.lastName(form.getLastName())
				.eMail(form.getEMail())
				.build();
		user.setBirthDate(LocalDateTime.parse(form.getBirthDate()));
		user.setChildFilter((int)ChronoUnit.YEARS.between(user.getBirthDate(), LocalDateTime.now()));
		usersRepository.save(user);
	}
	@Override
	public void updateUser(Integer userId, UserForm userForm) {
		User user = usersRepository.getById(userId);
		user.setFirstName(userForm.getFirstName());
		user.setLastName(userForm.getLastName());
		user.setEMail(userForm.getEMail());
		user.setBirthDate(LocalDateTime.parse(userForm.getBirthDate()));
		if (userForm.getChildFilter() == null)
			user.setChildFilter((int)ChronoUnit.YEARS.between(user.getBirthDate(), LocalDateTime.now()));
		else
			user.setChildFilter(userForm.getChildFilter());
		usersRepository.save(user);
	}
	@Override
	public User getUser(Integer userId) {
		return usersRepository.getById(userId);
	}
	@Override
	public void deleteUser(Integer userId) {
		usersRepository.deleteById(userId);
	}
	@Override
	public void addFilmToUser(Integer userId, Integer filmId) {
		SeenFilm seenFilm = seenFilmsRepository
				.findByViewerIsAndWatchedIs(usersRepository.getById(userId), filmsRepository.getById(filmId));
		if (seenFilm == null) {
			seenFilm = SeenFilm.builder()
					.viewer(usersRepository.getById(userId))
					.watched(filmsRepository.getById(filmId))
					.watchDate(LocalDateTime.now())
					.build();
		}
		else
			seenFilm.setWatchDate(LocalDateTime.now());
		seenFilmsRepository.save(seenFilm);
	}
}
