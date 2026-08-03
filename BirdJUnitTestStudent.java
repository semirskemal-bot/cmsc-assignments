/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Bird class, including its constructor, getters, movement, sound, and string representation.
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

public class BirdJUnitTestStudent {

    private Bird bird;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        bird = new Bird("Tweety", 2, "Canary", "Yellow", "images/bird.png");
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testConstructorAndGetName() {
        assertEquals("Tweety", bird.getName());
    }

    @Test
    public void testGetAge() {
        assertEquals(2, bird.getAge());
    }

    @Test
    public void testGetSpecies() {
        assertEquals("Canary", bird.getSpecies());
    }

    @Test
    public void testGetColor() {
        assertEquals("Yellow", bird.getColor());
    }

    @Test
    public void testGetImagePath() {
        assertEquals("images/bird.png", bird.getImagePath());
    }

    @Test
    public void testMakeSoundProducesOutput() {
        bird.makeSound();
        assertFalse(outputStream.toString().trim().isEmpty());
    }

    @Test
    public void testMoveProducesOutput() {
        bird.move();
        assertFalse(outputStream.toString().trim().isEmpty());
    }

    @Test
    public void testToStringContainsBirdInformation() {
        String result = bird.toString();

        assertTrue(result.contains("Tweety"));
        assertTrue(result.contains("2"));
        assertTrue(result.contains("Canary"));
        assertTrue(result.contains("Yellow"));
    }
}
