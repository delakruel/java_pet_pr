package ru.pcs.web.forms;
import lombok.Data;

@Data
public class UserForm {
	private String firstName;
	private String lastName;
	private String eMail;
	private String birthDate;
	private Integer childFilter;
}
