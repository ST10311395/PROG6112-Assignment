package student;

public class StudentArray {
    // ID of the student
    private String studentId;   
    // Name of the student
    private String studentName; 
    // Age of the student
    private int studentAge;       
   // Email of the student    
    private String studentEmail;     
    // Course the student is enrolled in
    private String studentCourse;     
    // Unique count identifier for the student
    private int studentCount;         

    // Constructor to initialize a new student object with provided details
    public StudentArray(String studentId, String studentName, int studentAge, String studentEmail, String studentCourse, int studentCount) {
         // Assign student ID
        this.studentId = studentId; 
        // Assign student name
        this.studentName = studentName; 
        // Assign student age
        this.studentAge = studentAge;  
        // Assign student email         
        this.studentEmail = studentEmail;
        // Assign student course
        this.studentCourse = studentCourse;    
        // Assign student count
        this.studentCount = studentCount;      
    }

    // Getter and Setter Methods

    public String getStudentId() {
        return studentId; // Return student ID
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId; // Set student ID
    }

    public String getStudentName() {
        return studentName; // Return student name
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName; // Set student name
    }

    public int getStudentAge() {
        return studentAge; // Return student age
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge; // Set student age
    }

    public String getStudentEmail() {
        return studentEmail; // Return student email
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail; // Set student email
    }

    public String getStudentCourse() {
        return studentCourse; // Return student course
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse; // Set student course
    }

    public int getStudentCount() {
        return studentCount; // Return student count
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount; // Set student count
    }

    // Override toString method to return a formatted string representation of the student
    @Override
    public String toString() {
        return "-------------------------------------" + "\n" +
               "Student " + studentCount + "\n" +
               "-------------------------------------" + "\n" +
               "Student ID: " + studentId + "\n" +
               "Name: " + studentName + "\n" +
               "Age: " + studentAge + "\n" +
               "Email: " + studentEmail + "\n" +
               "Course: " + studentCourse;
    }
}
