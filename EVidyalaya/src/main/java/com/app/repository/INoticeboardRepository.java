package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.NoticeBoard;

public interface INoticeboardRepository extends JpaRepository<NoticeBoard, Long> {

	public List<NoticeBoard> findByFaculty(Long facultyId);

	public List<NoticeBoard> findAll();

}
