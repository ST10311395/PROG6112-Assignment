package progassignment2;

// Employee class to represent an employee's data and payroll calculations
public class Employee {
    // Instance variables to store employee details
    private String name; // Name of the employee
    private int age; // Age of the employee
    private int hoursWorked; // Total regular hours worked by the employee
    private int employeeID; // Employee ID
    private int overtimeHours; // Overtime hours worked by the employee
    
    // Constant for overtime rate
    private static final double OVERTIME_RATE = 20; // $20 per overtime hour

    // Constructor to initialize an employee object with the provided details
    public Employee(String name, int age, int hoursWorked, int overtimeHours) {
        this.name = name;
        this.age = age;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
    }

    // Getter method to retrieve the employee's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the employee's age
    public int getAge() {
        return age;
    }

    // Getter method to retrieve the employee's ID
    public int getEmployeeID() { 
        return employeeID;
    }
    
     // Getter method to retrieve the employee's worked hours
    public int getHoursWorked() { 
        return hoursWorked;
    }

    // Setter method to set the employee's ID
    public void setEmployeeID(int employeeID) { // Added setter for Employee ID
        this.employeeID = employeeID;
    }

    // Method to calculate the salary based on regular hours worked
    public double calculateSalary() {
        // Example calculation: $15 per hour worked.
        return hoursWorked * 15;
    }

    // Getter method to retrieve the overtime hours worked by the employee
    public int getOvertimeHours() {
        return overtimeHours;
    }

    // Method to calculate overtime pay based on overtime hours worked
    public double calculateOvertimePay() {
        return overtimeHours * OVERTIME_RATE; // Overtime pay is calculated at a fixed rate
    }
}
