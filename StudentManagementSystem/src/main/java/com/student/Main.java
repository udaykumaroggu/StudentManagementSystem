package com.student;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static StudentService service = new StudentService();

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			choice = readInt("Enter your choice: ");
			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				service.displayAllStudents();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				System.out.println("Thank you for using the application!");
				break;
			default:
				System.out.println("Invalid choice! Try again.");
			}
		} while (choice != 6);
		sc.close();
	}

	public static void addStudent() {
		int id = readInt("Enter Student ID: ");
		String name = readNonEmpty("Enter Student Name: ");
		String email = readEmail();
		int[] marks = new int[3];
		for (int i = 0; i < marks.length; i++) {
			marks[i] = readMark("Enter Subject " + (i + 1) + " Marks: ");
		}
		Student student = new Student(id, name, email, marks);
		service.addStudent(student);
	}

	public static void searchStudent() {
		int id = readInt("Enter Student ID: ");
		Student student = service.searchStudent(id);
		if (student != null) {
			student.displayStudent();
		} else {
			System.out.println("Student not found!");
		}
	}

	public static void updateStudent() {
		int id = readInt("Enter Student ID: ");
		String name = readNonEmpty("Enter New Name: ");
		String email = readEmail();
		service.updateStudent(id, name, email);
	}

	public static void deleteStudent() {
		int id = readInt("Enter Student ID: ");
		service.deleteStudent(id);
	}

	public static int readInt(String message) {
		while (true) {
			System.out.print(message);
			try {
				int value = Integer.parseInt(sc.nextLine().trim());
				if (value <= 0) {
					System.out.println("Enter a positive number.");
					continue;
				}
				return value;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
		}
	}

	public static String readNonEmpty(String message) {
		while (true) {
			System.out.print(message);
			String value = sc.nextLine().trim();
			if (!value.isEmpty()) {
				return value;
			}
			System.out.println("Input cannot be empty.");
		}
	}

	public static String readEmail() {
		while (true) {
			System.out.print("Enter Email: ");
			String email = sc.nextLine().trim();
			if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
				return email;
			}
			System.out.println("Please enter a valid email.");
		}
	}

	public static int readMark(String message) {
		while (true) {
			System.out.print(message);
			try {
				int mark = Integer.parseInt(sc.nextLine().trim());

				if (mark >= 0 && mark <= 100) {
					return mark;
				}
				System.out.println("Marks must be between 0 and 100.");
			} catch (NumberFormatException e) {
				System.out.println("Please enter valid marks.");
			}
		}
	}
}
