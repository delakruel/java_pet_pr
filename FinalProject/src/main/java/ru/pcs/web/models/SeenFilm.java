package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "seen_films")
public class SeenFilm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime watchDate;
	@ManyToOne
	@JoinColumn(name = "id_acc")
	private User viewer;
	@ManyToOne
	@JoinColumn(name = "id_film")
	private Film watched;
}