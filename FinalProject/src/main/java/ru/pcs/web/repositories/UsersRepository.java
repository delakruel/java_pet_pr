package ru.pcs.web.repositories;

import ru.pcs.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
