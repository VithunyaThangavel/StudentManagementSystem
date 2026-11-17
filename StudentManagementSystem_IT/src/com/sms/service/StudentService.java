package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {
	// CRUD related
	/**
	 * Method: - Add std - Get all std - Get std by id - View all std - Update std
	 * by id - Delete std by id
	 */

	boolean addStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentById(int id);

	boolean updateStudent(int id, Student student);

	boolean deleteStudent(int id);
}