package com.app.entities;

import java.sql.Date;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "timetable")
public class TimeTable extends BaseEntity {

	@NotBlank(message = "date is required")
	private Date date;
	@NotBlank(message = "start time  is required")
	@Column(name = "starttime")
	private LocalTime startTime;
	@NotBlank(message = "end time  is required")
	@Column(name = "endtime")
	private LocalTime endTime;
//	@NotBlank(message = "faculty id is required")
	@ManyToOne
	@JoinColumn(name="facultyid")
	private User facultyId;
//	@NotBlank(message = "faculty name  is required")
	@Column(name = "facultyname", length = 45)
	private String facultyName;
	@NotBlank(message = "platform  is required")
	@Column(length = 20)
	private String platform;
	@NotBlank(message = "link is required")
	@Column(length = 200)
	private String link;
	@NotBlank(message = "module name  is required")
	@Column(name = "modulename", length = 45)
	private String moduleName;

}
