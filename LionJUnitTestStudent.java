/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Lion class, including its constructor, getters, movement, sound, and string representation.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LionJUnitTestStudent {

    private Lion lion;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        lion = new Lion("Simba", 5, "African Lion", "Golden", "images/lion.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testConstructorAndGetName() {
        assertEquals("Simba", lion.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(5, lion.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("African Lion", lion.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Golden", lion.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/lion.png", lion.getImagePath());
    }

    @Test
    public void testMakeSoundProducesOutput() {
        lion.makeSound();
        assertFalse(outputStream.toString().trim().isEmpty());
    }

    @Test
    public void testMoveProducesOutput() {
        lion.move();
        assertFalse(outputStream.toString().trim().isEmpty());
    }

    @Test
    public void testToStringContainsLionInformation() {
        String result = lion.toString();

        assertTrue(result.contains("Simba"));
        assertTrue(result.contains("5"));
        assertTrue(result.contains("African Lion"));
        assertTrue(result.contains("Golden"));
    }
}
