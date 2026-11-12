package com.student;

public class Student {
	private int id;
	private String name;
	private String email;
	private int[] marks;

	public Student(int id, String name, String email, int[] marks) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double calculateAverage() {
		int total = 0;
		for (int mark : marks) {
			total += mark;
		}
		return (double) total / marks.length;
	}

	public String calculateGrade() {
		double average = calculateAverage();
		if (average >= 90) {
			return "A";
		} else if (average >= 75) {
			return "B";
		} else if (average >= 60) {
			return "C";
		} else if (average >= 40) {
			return "D";
		} else {
			return "Fail";
		}
	}

	public void displayStudent() {
		System.out.println("------------------------------");
		System.out.println("Student ID : " + id);
		System.out.println("Name       : " + name);
		System.out.println("Email      : " + email);
		System.out.print("Marks      : ");
		for (int mark : marks) {
			System.out.print(mark + " ");
		}
		System.out.println();
		System.out.println("Average    : " + calculateAverage());
		System.out.println("Grade      : " + calculateGrade());
		System.out.println("------------------------------");
	}
}
