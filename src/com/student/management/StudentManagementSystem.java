package com.student.management;
import java.util.ArrayList;  // Importing ArrayList to store student records
import java.util.Scanner;    // Importing Scanner to take user input


	// Class to represent a Student
	class Student {
	    int rollNo;      // Stores Roll Number
	    String name;     // Stores Student Name
	    double marks;    // Stores Marks

	    // Constructor to initialize Student details
	    Student(int rollNo, String name, double marks) {
	        this.rollNo = rollNo;
	        this.name = name;
	        this.marks = marks;
	    }

	    // Method to display student details
	    void display() {
	        System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks);
	    }
	}

	// Main class for Student Management System
	public class StudentManagementSystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);  // Scanner object to read user input
	        ArrayList<Student> students = new ArrayList<>();  // ArrayList to store student records

	        while (true) {  // Infinite loop for menu-driven program
	            // Display menu options
	            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Search Student by Roll No");
	            System.out.println("4. Delete Student");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();  // Read user choice
	            scanner.nextLine(); // Consume newline character after integer input

	            switch (choice) {
	                case 1:
	                    // Add a new student
	                    System.out.print("Enter Roll No: ");
	                    int rollNo = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter Name: ");
	                    String name = scanner.nextLine();

	                    System.out.print("Enter Marks: ");
	                    double marks = scanner.nextDouble();

	                    students.add(new Student(rollNo, name, marks)); // Add student to list
	                    System.out.println("✅ Student added successfully!");
	                    break;

	                case 2:
	                    // View all students
	                    System.out.println("\n===== Student List =====");
	                    if (students.isEmpty()) {
	                        System.out.println("No students found!");  // If no student is in the list
	                    } else {
	                        for (Student s : students) {
	                            s.display(); // Display each student details
	                        }
	                    }
	                    break;

	                case 3:
	                    // Search student by roll number
	                    System.out.print("Enter Roll No to search: ");
	                    int searchRollNo = scanner.nextInt();
	                    boolean found = false; // Flag to track if student is found

	                    for (Student s : students) {
	                        if (s.rollNo == searchRollNo) { // Check if roll number matches
	                            System.out.println("✅ Student Found!");
	                            s.display(); // Display student details
	                            found = true;
	                            break; // Exit loop after finding student
	                        }
	                    }

	                    if (!found) {
	                        System.out.println("❌ Student not found!");
	                    }
	                    break;

	                case 4:
	                    // Delete student by roll number
	                    System.out.print("Enter Roll No to delete: ");
	                    int deleteRollNo = scanner.nextInt();
	                    boolean deleted = false; // Flag to track if student is deleted

	                    for (Student s : students) {
	                        if (s.rollNo == deleteRollNo) { // Check if roll number matches
	                            students.remove(s); // Remove student from list
	                            System.out.println("✅ Student deleted successfully!");
	                            deleted = true;
	                            break; // Exit loop after deletion
	                        }
	                    }

	                    if (!deleted) {
	                        System.out.println("❌ Student not found!");
	                    }
	                    break;

	                case 5:
	                    // Exit the program
	                    System.out.println("🔴 Exiting Student Management System...");
	                    scanner.close(); // Close scanner to prevent resource leak
	                    return; // Terminate program

	                default:
	                    System.out.println("❌ Invalid choice! Please enter a valid option.");
	            }
	        }
	    }
	}

