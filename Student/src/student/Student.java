// Katelyn Narain
// ST10311395
// PROG6112 Assignment 1
// Question 1

package student;

// Import Scanner for user input
import java.util.Scanner;

public class Student {
    // Array to store student objects, using a fixed size for simplicity
    private StudentArray[] student; 
    // Counter to track the number of students
    private int studentCount; 
    // Scanner object for user input
    private Scanner scanner;        

    // Constructor to initialize the Student array and other variables
    public Student() {
        // Initialize the student array with a maximum size of 100
        student = new StudentArray[100]; 
        // Start count from 0 to align with array indexing
        studentCount = 0;  
        // Initialize the scanner
        scanner = new Scanner(System.in); 
    }

    // Method to capture and save a new student's details
    public void saveStudent() {
        // Clear scanner buffer before reading new input
        scanner.nextLine();
        // Prompt user to enter student details
        System.out.println("\nCAPTURE A NEW STUDENT");
        System.out.println("************************************");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student name: ");
        String studentName = scanner.nextLine();

        // Initialize student age variable
        int studentAge = 1; 
        // Flag for valid input
        boolean validInput = false;

        // Validate student age input
        while (!validInput) {
            System.out.print("Enter Student age: ");
            try {
                studentAge = Integer.parseInt(scanner.nextLine());
                // Check if the age is valid
                if (studentAge < 16) { 
                    System.out.println("You have entered an incorrect student age! Please re-enter the student age >>");
                } else {
                    // Set flag to true if age is valid
                    validInput = true; 
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age! Please re-enter the student age >>");
            }
        }

        // Continue to capture other student details
        System.out.print("Enter Student email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Enter Student Course: ");
        String studentCourse = scanner.nextLine();

        // Create a new student object and save it in the array
        StudentArray newStudent = new StudentArray(studentId, studentName, studentAge, studentEmail, studentCourse, studentCount + 1);
        student[studentCount] = newStudent; // Add to array
        studentCount++; // Increment the student count
        System.out.println("Student saved successfully.");
    }

    // Method to search for a student by their ID
    //Title: Check if a value is present in an Array in Java
        //Author: Geeks for geeks
        //date: 9 Novemeber 2023
        //version: 1
        // availability:https://www.geeksforgeeks.org/check-if-a-value-is-present-in-an-array-in-java/ 

    public StudentArray searchStudent(String studentId) {
        // Loop through the student array to find the student with the matching ID
        for (int i = 0; i < studentCount; i++) {
            if (student[i] != null && student[i].getStudentId().equalsIgnoreCase(studentId)) {
                // Return the student object if found
                return student[i];
            }
        }
        // Return null if not found
        return null;
    }

    // Method to delete a student by their ID
    
        //Title: Remove an Element at Specific Index from an Array in Java
        //Author: Geeks for geeks
        //date: 19 April 2023
        //version: 1
        // availability: https://www.geeksforgeeks.org/remove-an-element-at-specific-index-from-an-array-in-java/ 

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String studentId = scanner.nextLine();
        // Flag to indicate if the student was found
        boolean found = false; 

        // Loop through the student array to find the student with the matching ID
        for (int i = 0; i < studentCount; i++) {
            if (student[i] != null && student[i].getStudentId().equalsIgnoreCase(studentId)) {
                // Confirm deletion
                System.out.print("Are you sure you want to delete this student? (y/n): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    // Shift remaining students to fill the gap
                    for (int j = i; j < studentCount - 1; j++) {
                        student[j] = student[j + 1];
                    }
                    // Clear the last entry
                    student[studentCount - 1] = null; 
                    // Decrement the student count
                    studentCount--; 
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Deletion canceled.");
                }
                // Set flag to true if a student is found
                found = true; 
                break;
            }
        }

        if (!found) {
            // Message if a student is not found
            System.out.println("Student not found."); 
        }
    }

    // Method to print a report of all students
    public void printStudentReport() {
        // Check if there are any students to display
        if (studentCount == 0) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nStudent Report:");
            // Loop through the student array and print each student
            for (int i = 0; i < studentCount; i++) {
                if (student[i] != null) {
                    System.out.println(student[i]);
                }
            }
        }
    }

    // Method to exit the application
    public void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
        // Close the scanner to release resources
        scanner.close(); 
    }

    // Getter method to return the array of students
    public StudentArray[] getStudent() {
        return student;
    }

    // Method to launch the main menu of the application
    public void launchMenu() {
        // Infinite loop to keep the menu running until exit
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("1. Capture a new student");
            System.out.println("2. Search for a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Print student report");
            System.out.println("5. Exit application");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                // Read user choice
                choice = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            // Switch-case to handle user choice
            switch (choice) {
                case 1:
                    // Capture new student
                    saveStudent(); 
                    break;
                case 2:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    // Search for student
                    StudentArray foundStudent = searchStudent(searchId); 
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    // Delete a student
                    deleteStudent();
                    break;
                case 4:
                    // Print student report
                    printStudentReport(); 
                    break;
                case 5:
                    // Exit the application
                    exitApplication(); 
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    // Main method to run the Student Management Application
    public static void main(String[] args) {
        // Initialize the Student manager with a maximum of 100 students
        Student manager = new Student();
        System.out.println("\nSTUDENT MANAGEMENT APPLICATION");
        System.out.println("************************************");
        System.out.print("Press (1) to launch menu, any other key to exit: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        // Launch menu or exit based on user choice
        if (choice.equals("1")) {
            // Launch menu
            manager.launchMenu(); 
        } else {
            System.out.println("Exiting application. Goodbye!");
        }
        // Close the scanner to release resources
        input.close(); 
    }
}
