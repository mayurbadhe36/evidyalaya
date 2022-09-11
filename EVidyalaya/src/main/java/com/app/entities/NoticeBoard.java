package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "noticeboard")
public class NoticeBoard extends BaseEntity {

	@NotBlank(message = "date is required")
	private LocalDate date;
	@NotBlank(message = "description is required")
	private String description;
	@ManyToOne
	@JoinColumn(name="facultyid")
	private User facultyId;
	@Column(name = "facultyname")
	private String facultyName;
	@NotBlank(message = "Module name is required")
	@Column(name = "modulename")
	private String moduleName;

}
