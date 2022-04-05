package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Film;
import ru.pcs.web.models.SeenFilm;
import ru.pcs.web.models.User;

import java.util.List;

public interface SeenFilmsRepository extends JpaRepository<SeenFilm, Integer> {
	SeenFilm findByViewerIsAndWatchedIs(User viewer, Film watched);
	List<SeenFilm> findAllByViewer_Id(Integer id);
}
