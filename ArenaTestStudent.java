/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Arena class, including its constructor, building properties, setters, getters, and string representation.
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

public class ArenaTestStudent {

    private Arena arena;

    @BeforeEach
    public void setUp() {
        arena = new Arena("Red", 200.0, 150.0, "images/arena.png");
    }

    @Test
    public void testConstructorValues() {
        assertEquals("Red", arena.getColor());
        assertEquals(200.0, arena.getLength(), 0.0001);
        assertEquals(150.0, arena.getWidth(), 0.0001);
        assertEquals("Arena", arena.getBuildingType());
        assertEquals("images/arena.png", arena.getImagePath());
    }

    @Test
    public void testSetSize() {
        arena.setSize(300.0, 225.0);

        assertEquals(300.0, arena.getLength(), 0.0001);
        assertEquals(225.0, arena.getWidth(), 0.0001);
    }

    @Test
    public void testSetColor() {
        arena.setColor("Blue");
        assertEquals("Blue", arena.getColor());
    }

    @Test
    public void testSetBuildingType() {
        arena.setBuildingType("Main Arena");
        assertEquals("Main Arena", arena.getBuildingType());
    }

    @Test
    public void testArenaImplementsBuilding() {
        assertTrue(arena instanceof Building);
    }

    @Test
    public void testToStringContainsBuildingInformation() {
        String result = arena.toString();

        assertTrue(result.contains("Arena"));
        assertTrue(result.contains("Red"));
        assertTrue(result.contains("200.0"));
        assertTrue(result.contains("150.0"));
    }
}
