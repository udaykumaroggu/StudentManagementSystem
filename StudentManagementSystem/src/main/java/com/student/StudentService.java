package com.student;

import java.util.ArrayList;

public class StudentService {
	private ArrayList<Student> students = new ArrayList<>();

	public boolean addStudent(Student student) {
		if (searchStudent(student.getId()) != null) {
			System.out.println("Student ID already exists!");
			return false;
		}
		students.add(student);
		System.out.println("Student added successfully!");
		return true;
	}

	public void displayAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No student records found.");
			return;
		}
		for (Student student : students) {
			student.displayStudent();
		}
	}

	public Student searchStudent(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public void updateStudent(int id, String name, String email) {
		Student student = searchStudent(id);
		if (student != null) {
			student.setName(name);
			student.setEmail(email);
			System.out.println("Student updated successfully!");
		} else {
			System.out.println("Student not found!");
		}
	}

	public void deleteStudent(int id) {
		Student student = searchStudent(id);
		if (student != null) {
			students.remove(student);
			System.out.println("Student deleted successfully!");
		} else {
			System.out.println("Student not found!");
		}
	}
}
