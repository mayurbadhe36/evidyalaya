package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Assignment;

public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {

	public List<Assignment> findAssignmentsByFaculty(long id);

}
