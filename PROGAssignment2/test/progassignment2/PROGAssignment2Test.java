package progassignment2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PROGAssignment2Test {
    private PROGAssignment2 progAssignment;  // Instance of the class under test
    private ByteArrayOutputStream outContent;  // Stream to capture System.out output

    // Setup method to initialize objects and redirect System.out
    @BeforeEach
    public void setUp() {
        progAssignment = new PROGAssignment2();  // Create a new instance of PROGAssignment2
        outContent = new ByteArrayOutputStream();  // Initialize ByteArrayOutputStream to capture output
        System.setOut(new PrintStream(outContent));  // Redirect System.out to the ByteArrayOutputStream
    }

    // Test case for adding an employee
    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("John Doe", 30, 40, 5);  // Create a new Employee object
        progAssignment.addEmployee(employee);  // Add the employee to the system
        
        List<Employee> employees = progAssignment.getEmployees();  // Retrieve the list of employees
        assertEquals(1, employees.size());  // Verify that there is one employee in the list
        assertEquals("John Doe", employees.get(0).getName());  // Verify the name of the employee
        assertEquals(30, employees.get(0).getAge());  // Verify the age of the employee
        assertEquals(40, employees.get(0).getHoursWorked());  // Verify the hours worked
        assertEquals(5, employees.get(0).getOvertimeHours());  // Verify the overtime hours
    }

    // Test case for displaying the payroll
    @Test
    public void testDisplayPayroll() {
        Employee employee1 = new Employee("John Doe", 30, 40, 5);  // Create first Employee object
        Employee employee2 = new Employee("Jane Smith", 25, 35, 8);  // Create second Employee object
        progAssignment.addEmployee(employee1);  // Add the first employee
        progAssignment.addEmployee(employee2);  // Add the second employee

        // Call the method to display the payroll
        progAssignment.displayPayroll();

        // Define the expected output string
        String expectedOutput = "Employee Payroll Report:\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Name: John Doe\n" +
                "Age: 30\n" +
                "Salary: R600.0\n" +
                "Overtime Pay: R100.0\n" +
                "Total Salary: R700.0\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Name: Jane Smith\n" +
                "Age: 25\n" +
                "Salary: R525.0\n" +
                "Overtime Pay: R160.0\n" +
                "Total Salary: R685.0\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        // Verify that the output matches the expected output
        assertEquals(expectedOutput.replace("\r", ""), outContent.toString().replace("\r", ""));  // Compare output ignoring line separators
    }

    // Test case for searching an employee
    @Test
    public void testSearchEmployee() {
        Employee employee1 = new Employee("John Doe", 30, 40, 5);  // Create first Employee object
        Employee employee2 = new Employee("Jane Smith", 25, 35, 8);  // Create second Employee object
        progAssignment.addEmployee(employee1);  // Add the first employee
        progAssignment.addEmployee(employee2);  // Add the second employee

        // Call the search method to find an employee by name
        progAssignment.searchEmployee("John Doe");
        
        // Define the expected output when employee is found
        String expectedOutput = "Employee Found:\n" +
                "Name: John Doe\n" +
                "Age: 30\n" +
                "Salary: R600.0\n" +
                "Overtime Pay: R100.0\n" +
                "Total Salary: R700.0\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        // Verify that the output matches the expected output for a found employee
        assertEquals(expectedOutput.replace("\r", ""), outContent.toString().replace("\r", ""));  // Compare output ignoring line separators
        
        // Clear the output stream for the next test
        outContent.reset();
        
        // Test searching for a non-existent employee
        progAssignment.searchEmployee("Nonexistent Employee");
        
        // Define the expected output when employee is not found
        String notFoundOutput = "Employee with name \"Nonexistent Employee\" not found.\n";
        
        // Verify that the output matches the expected output for a non-existent employee
        assertEquals(notFoundOutput.replace("\r", ""), outContent.toString().replace("\r", ""));  // Compare output ignoring line separators
    }
}
