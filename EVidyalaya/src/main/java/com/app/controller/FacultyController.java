package com.app.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.entities.Assignment;
import com.app.entities.NoticeBoard;
import com.app.filehandlingutils.FacultyAssignmentUploadResponse;
import com.app.filehandlingutils.FileDownloadUtil;
import com.app.filehandlingutils.FileUploadResponse;
import com.app.filehandlingutils.FileUploadUtils;
import com.app.service.IFacultyService;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

	@Autowired
	IFacultyService facultyService;

	@PostMapping("/addNoticeboard")
	public ResponseEntity<?> addNoticeBoard(@RequestBody @Valid NoticeBoard noticeboard, @RequestParam Long facultyId) {
		try {
			return new ResponseEntity<>(facultyService.addNoticeBoard(noticeboard, facultyId), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/uploadAssignment")
	public ResponseEntity<FacultyAssignmentUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile)
			throws IOException {
		try {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			long size = multipartFile.getSize();
			String filecode = FileUploadUtils.saveFile(fileName, multipartFile);
			FacultyAssignmentUploadResponse response = new FacultyAssignmentUploadResponse();
			response.setFileName(fileName);
			response.setSize(size);
			response.setDownloadUri("/downloadFile/" + filecode);
			response.setFilecode(filecode);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (RuntimeException e) {
			throw new RuntimeException("Something went wrong");
		}
	}

	@GetMapping("/downloadFile/{fileCode}")
	public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
		FileDownloadUtil downloadUtil = new FileDownloadUtil();

		Resource resource = null;
		try {
			resource = downloadUtil.getFileAsResource(fileCode);
		} catch (IOException e) {
			return ResponseEntity.internalServerError().build();
		}

		if (resource == null) {
			return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
		}

		String contentType = "application/octet-stream";
		String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
	}

	@PostMapping("/addAssignment")
	public ResponseEntity<?> addAssignment(@RequestBody @Valid Assignment assignment, @RequestParam Long facultyId) {
		try {
			return new ResponseEntity<>(facultyService.addAssignment(assignment, facultyId), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

}
