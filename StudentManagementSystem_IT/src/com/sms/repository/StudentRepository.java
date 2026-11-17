package com.sms.repository;

import java.util.ArrayList;
import java.util.List;

import com.sms.model.Student;

public class StudentRepository {
	/**
	 * Method:
	 * - Add std
	 * - Searching all std
	 * - Search by id
	 * - View all std
	 * - Update std by id
	 * - Delete std by id
	 */
	
	private final List<Student> students = new ArrayList<>();
	
	public boolean add(Student student) { // return type - boolean - return keyword.
		if(findById(student.getStudentId()) != null || findByEmail(student.getEmail()) != null) {
				//null- data already available - false
			return false;
		}
		return students.add(student);
	}

	//Logic to find by id:
	public Student findById(int id) {
		for(Student student : students) { //(class instance : object)
			if(student.getStudentId() == id) {
				return student;
			}
		}
		return null; // findById() can be called to find anywhere when needed
	}
	
	//Logic to find by email:
	public Student findByEmail(String email) {
		for(Student student : students) {
			if(student.getEmail().equalsIgnoreCase(email)) {
				return student;
			}
		}
		return null;
	}
	
	public final List<Student> findAll(){
		return new ArrayList<>(students);
	}
	
	public boolean delete(int id) {
		Student existing = findById(id);
		return existing != null && students.remove(existing); // if data presents, remove user 
	}
	
	public boolean update(int id, Student updated) {
		//if id = null - false
		Student existing = findById(id);
		if(existing == null) {
			return false;
		}
		
		//if owner exists, find the email, if owner ! empty & stdId ! equal - false 
		Student emailOwner = findByEmail(updated.getEmail());
		if(emailOwner != null && emailOwner.getStudentId() != id) {
			return false;
		}
		
		//if email, stdId of owner equal - update(set - write) 
		existing.setStudentName(emailOwner.getStudentName());
		existing.setEmail(emailOwner.getEmail());
		existing.setDepartment(emailOwner.getDepartment());
		existing.setPhoneNumber(emailOwner.getPhoneNumber());
		return true;
		
	}
	
}