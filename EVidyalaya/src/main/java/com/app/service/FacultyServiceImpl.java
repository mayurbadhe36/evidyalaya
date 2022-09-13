package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.Assignment;
import com.app.entities.NoticeBoard;
import com.app.entities.User;
import com.app.repository.IAssignmentRepository;
import com.app.repository.INoticeboardRepository;
import com.app.repository.IUserRepository;

@Service
public class FacultyServiceImpl implements IFacultyService {

	@Autowired
	private INoticeboardRepository noticeRepo;

	@Autowired
	private IAssignmentRepository assignRepo;

	@Autowired
	private IUserRepository userRepo;

//	@Autowired
//	private IAssignmentAnswerRepository answerRepo;
//
//	@Autowired
//	private TimetableRepository timetableRepo;

	@Override
	public Assignment addAssignment(Assignment assignment, Long facultyId) {

		User u = userRepo.findById(facultyId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Faculty ID !!!!!!!"));
		assignment.setFaculty(u);
		return assignRepo.save(assignment);
	}

//
//	@Override
//	public List<Assignment> getAllAssignment() {
//		return assignRepo.findAll();
//
//	}
//
//	@Override
//	public List<Assignment> getAssignmentByfacultyId(Long faculityId) {
//		return assignRepo.findAssignmentsByFaculty(faculityId);
//	}
//
	@Override
	public NoticeBoard addNoticeBoard(NoticeBoard notice, Long facultyId) {
		User u = userRepo.findById(facultyId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Faculty ID !!!!!!!"));
		notice.setFaculty(u);
		return noticeRepo.save(notice);
	}
//
//	@Override
//	public List<NoticeBoard> getAllNotice() {
//		return noticeRepo.findAll();
//	}
//
//	@Override
//	public List<NoticeBoard> getNoticeByFaculty(Long facultyId) {
//		return noticeRepo.findByFaculty(facultyId);
//	}
//
//	@Override
//	public NoticeBoard getNoticeById(Long id) {
//		return noticeRepo.findById(id).get();
//	}
//
//	@Override
//	public NoticeBoard updateNoticeboard(NoticeBoard notice) {
//		return noticeRepo.save(notice);
//	}
//
//	@Override
//	public boolean deleteNotice(long id) {
//		NoticeBoard n = noticeRepo.findById(id).get();
//		if (n != null) {
//			noticeRepo.delete(n);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public Assignment getAssignmentById(long id) {
//		return assignRepo.findById(id).get();
//	}
//
//	@Override
//	public Assignment updateAssignment(Assignment assignment) {
//		return assignRepo.save(assignment);
//	}
//
//	@Override
//	public boolean deleteAssignment(long id) {
//		Assignment a = assignRepo.findById(id).get();
//		if (a != null) {
//			assignRepo.delete(a);
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public List<AssignmentAnswer> getAllSubmitAnswerByFacultyId(long id) {
//		return answerRepo.findByFacultyId(id);
//	}
//
//	@Override
//	public AssignmentAnswer getAssignmentAnswerById(long id) {
//		return answerRepo.findById(id).get();
//	}
//
//	@Override
//	public boolean updateGrade(long aid, String grade) {
//		AssignmentAnswer as = answerRepo.findById(aid).get();
//		if (as != null) {
//			as.setGrade(grade);
//			as.setId(aid);
//			answerRepo.save(as);
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public String checkGrade(long fid, long aid) {
//		AssignmentAnswer as = answerRepo.findByFacultyAndId(fid, aid);
//		if (as != null) {
//			return as.getGrade();
//		}
//		return null;
//	}
//
//	@Override
//	public User updateProfile(User u) {
//
//		User oldUser = userRepo.findById(u.getId()).get();
//
//		if (oldUser != null) {
//			u.setPassword(oldUser.getPassword());
//			u.setRole(oldUser.getRole());
//			return userRepo.save(u);
//		}
//
//		return null;
//	}
//
//	@Override
//	public TimeTable addTimeTable(TimeTable timeTable) {
//		return timetableRepo.save(timeTable);
//	}
//
//	@Override
//	public TimeTable getTimeTableById(long id) {
//		return timetableRepo.findById(id).get();
//	}
//
//	@Override
//	public List<TimeTable> getAllTimeTableByFacultyId(long id) {
//		return timetableRepo.findByFacultyOrderByIdDesc(id);
//	}
//
//	@Override
//	public List<TimeTable> getAllTimeTable() {
//		return timetableRepo.findAll();
//	}
//
//	@Override
//	public boolean deleteTimeTable(long id) {
//		TimeTable time = timetableRepo.findById(id).get();
//		if (time != null) {
//			timetableRepo.delete(time);
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public TimeTable updateTimeTable(TimeTable timeTable) {
//		return timetableRepo.save(timeTable);
//	}

}
