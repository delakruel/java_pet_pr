package ru.pcs.web.forms;

import lombok.Data;

@Data
public class FilmForm {
	private String name;
	private Integer year;
	private String genre;
	private Integer rating;
}
