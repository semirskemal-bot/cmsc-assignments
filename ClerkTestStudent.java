/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Clerk class, including its constructor, inherited getters, and overridden toString method.
 * Due: 08/03/2026
 * Date: 08/02/2026
 * Platform/compiler: Eclipse IDE / JUnit 5
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
 * Print your Name here: Semir Kemal
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClerkTestStudent {

    private Clerk clerk;

    @BeforeEach
    public void setUp() {
        clerk = new Clerk("Maria", 34, 6, "Ticket Clerk", "images/clerk.png");
    }

    @Test
    public void testConstructorAndGetName() {
        assertEquals("Maria", clerk.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(34, clerk.getAge());
    }

    @Test
    public void testGetYearsWorked() {
        assertEquals(6, clerk.getYearsWorked());
    }

    @Test
    public void testGetJob() {
        assertEquals("Ticket Clerk", clerk.getJob());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/clerk.png", clerk.getImagePath());
    }

    @Test
    public void testClerkIsPerson() {
        assertTrue(clerk instanceof Person);
    }

    @Test
    public void testToStringIncludesClerkAndPersonData() {
        String result = clerk.toString();

        assertTrue(result.startsWith("Clerk"));
        assertTrue(result.contains("Maria"));
        assertTrue(result.contains("34"));
        assertTrue(result.contains("Ticket Clerk"));
        assertTrue(result.contains("6"));
    }
}
