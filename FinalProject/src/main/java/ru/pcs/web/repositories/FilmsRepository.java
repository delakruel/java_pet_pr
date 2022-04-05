package ru.pcs.web.repositories;

import ru.pcs.web.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmsRepository extends JpaRepository<Film, Integer> {
	List<Film> findAllByRatingLessThanEqual(Integer rating);
}
