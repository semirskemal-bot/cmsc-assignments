/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Acrobatic class, including its constructor, inherited getters, and overridden toString method.
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

public class AcrobaticTestStudent {

    private Acrobatic acrobatic;

    @BeforeEach
    public void setUp() {
        acrobatic = new Acrobatic(
                "Alex",
                27,
                4,
                "Aerial Acrobatic",
                "images/acrobatic.png");
    }

    @Test
    public void testConstructorAndGetName() {
        assertEquals("Alex", acrobatic.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(27, acrobatic.getAge());
    }

    @Test
    public void testGetYearsWorked() {
        assertEquals(4, acrobatic.getYearsWorked());
    }

    @Test
    public void testGetJob() {
        assertEquals("Aerial Acrobatic", acrobatic.getJob());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/acrobatic.png", acrobatic.getImagePath());
    }

    @Test
    public void testAcrobaticIsPerson() {
        assertTrue(acrobatic instanceof Person);
    }

    @Test
    public void testToStringIncludesAcrobaticAndPersonData() {
        String result = acrobatic.toString();

        assertTrue(result.startsWith("Acrobatic"));
        assertTrue(result.contains("Alex"));
        assertTrue(result.contains("27"));
        assertTrue(result.contains("Aerial Acrobatic"));
        assertTrue(result.contains("4"));
    }
}
