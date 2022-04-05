package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String eMail;
	private LocalDateTime birthDate;
	private Integer childFilter;
	@OneToMany(mappedBy = "viewer")
	private List<SeenFilm> seenFilms;
}
