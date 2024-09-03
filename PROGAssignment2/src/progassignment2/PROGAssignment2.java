package progassignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PROGAssignment2 {
    private ArrayList<Employee> employees;  // List to store Employee objects
    
    // Constructor to initialize the employees list
    public PROGAssignment2() {
        employees = new ArrayList<>();
    }
    
    // Method to add an employee to the list
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    // Method to display the payroll report for all employees
    public void displayPayroll() {
        System.out.println("Employee Payroll Report:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        // Loop through each employee in the list
        for (Employee emp : employees) {
            System.out.println("Name: " + emp.getName());
            System.out.println("Age: " + emp.getAge());
            System.out.println("Salary: R" + emp.calculateSalary());
            
            // Calculate overtime pay using the existing employee object
            double overtimePay = emp.calculateOvertimePay(); 
            System.out.println("Overtime Pay: R" + overtimePay);
            
            System.out.println("Total Salary: R" + (emp.calculateSalary() + overtimePay));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    // Method to search for an employee by name
    public void searchEmployee(String name) {
        boolean found = false;  // Flag to indicate if an employee is found

        // Loop through each employee in the list
        for (Employee emp : employees) {
            if (emp.getName().equalsIgnoreCase(name)) {  // Compare ignoring case
                found = true;
                System.out.println("Employee Found:");
                System.out.println("Name: " + emp.getName());
                System.out.println("Age: " + emp.getAge());
                System.out.println("Salary: R" + emp.calculateSalary());
                double overtimePay = emp.calculateOvertimePay(); 
                System.out.println("Overtime Pay: R" + overtimePay);
                System.out.println("Total Salary: R" + (emp.calculateSalary() + overtimePay));
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;  // Exit the loop once the employee is found
            }
        }

        if (!found) {  // If no employee is found
            System.out.println("Employee with name \"" + name + "\" not found.");
        }
    }

    // Getter method to retrieve the list of employees
    public List<Employee> getEmployees() {
        return employees;
    }

    public static void main(String[] args) {
        PROGAssignment2 system = new PROGAssignment2();
        Scanner scanner = new Scanner(System.in);

        // Ask user for input to add a new employee
        System.out.println("Enter the employee's name:");
        String name = scanner.nextLine();  // Read the name
        
        System.out.println("Enter the employee's age:");
        int age = scanner.nextInt();  // Read the age
        
        System.out.println("Enter the number of hours worked:");
        int hoursWorked = scanner.nextInt();  // Read hours worked
        
        System.out.println("Enter the number of overtime hours worked:");
        int overtimeHours = scanner.nextInt();  // Read overtime hours
        
        // Create an employee object with user input
        Employee employee = new Employee(name, age, hoursWorked, overtimeHours);
       
        // Add the employee to the system
        system.addEmployee(employee);

        // Display the payroll report for all employees
        system.displayPayroll();

        // Search for an employee by name
        scanner.nextLine();  // Consume the remaining newline character
        System.out.println("Enter the name of the employee you want to search for:");
        String searchName = scanner.nextLine();
        system.searchEmployee(searchName);  // Call the search method
        
        // Close the scanner to release resources
        scanner.close();
    }
}
