package student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StudentTest {
    private Student studentManager;

    @BeforeEach
    public void setUp() {
        studentManager = new Student(); // Initialize the Student manager
        // Manually adding students for testing purposes
        studentManager.getStudent()[0] = new StudentArray("10111", "J.Bloggs", 19, "jblogs@ymail.com", "disd", 1);
        studentManager.getStudent()[1] = new StudentArray("10112", "J.Doe", 21, "jdoe@ymail.com", "disd", 2);
        studentManager.getStudent()[2] = new StudentArray("10113", "P.Parker", 20, "spidey@ymail.com", "disn", 3);
    }

    @Test
    public void testSearchStudent() {
        // Test searching for an existing student
        StudentArray foundStudent = studentManager.searchStudent("10111");
        assertNotNull(foundStudent);
        assertEquals("10111", foundStudent.getStudentId());
        assertEquals("J.Bloggs", foundStudent.getStudentName());

        // Test searching for a non-existing student
        StudentArray notFoundStudent = studentManager.searchStudent("99999");
        assertNull(notFoundStudent);
    }

    @Test
    public void testDeleteStudent() {
        // Simulate user input for confirmation 'y'
        String input = "y\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Test deleting an existing student
        studentManager.deleteStudent();  // Input must be provided; simulating "10111" as input
        StudentArray deletedStudent = studentManager.searchStudent("10111");
        assertNull(deletedStudent);  // Student should be deleted

        // Ensure remaining students are intact
        assertNotNull(studentManager.searchStudent("10112"));
        assertNotNull(studentManager.searchStudent("10113"));

        // Simulate user input for confirmation 'n' (canceled deletion)
        input = "n\n";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Test deleting a non-existing student
        studentManager.deleteStudent();  // Input must be provided; simulating "99999" as input
        assertNotNull(studentManager.searchStudent("10112")); // Ensure no deletion happened
        assertNotNull(studentManager.searchStudent("10113"));
    }
}
