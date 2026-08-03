/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the TicketingOffice class, including its constructor, building properties, setters, getters, and string representation.
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

public class TicketingOfficeTestStudent {

    private TicketingOffice office;

    @BeforeEach
    public void setUp() {
        office = new TicketingOffice(
                "White",
                60.0,
                40.0,
                "images/ticketing-office.png");
    }

    @Test
    public void testConstructorValues() {
        assertEquals("White", office.getColor());
        assertEquals(60.0, office.getLength(), 0.0001);
        assertEquals(40.0, office.getWidth(), 0.0001);
        assertEquals("Ticketing Office", office.getBuildingType());
        assertEquals("images/ticketing-office.png", office.getImagePath());
    }

    @Test
    public void testSetSize() {
        office.setSize(75.0, 55.0);

        assertEquals(75.0, office.getLength(), 0.0001);
        assertEquals(55.0, office.getWidth(), 0.0001);
    }

    @Test
    public void testSetColor() {
        office.setColor("Yellow");
        assertEquals("Yellow", office.getColor());
    }

    @Test
    public void testSetBuildingType() {
        office.setBuildingType("Front Ticket Office");
        assertEquals("Front Ticket Office", office.getBuildingType());
    }

    @Test
    public void testTicketingOfficeImplementsBuilding() {
        assertTrue(office instanceof Building);
    }

    @Test
    public void testToStringContainsBuildingInformation() {
        String result = office.toString();

        assertTrue(result.contains("Ticket"));
        assertTrue(result.contains("White"));
        assertTrue(result.contains("60.0"));
        assertTrue(result.contains("40.0"));
    }
}
