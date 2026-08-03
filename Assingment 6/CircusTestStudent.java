/*
 * Class: CMSC203
 * Instructor: Dr. Ginberg
 * Description: JUnit tests for the Circus data manager, including aggregation, adding, searching, displaying, and selection sorting.
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
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircusTestStudent {

    private Circus circus;
    private Dog dog;
    private Horse horse;
    private Bird bird;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        circus = new Circus();

        dog = new Dog("Zeus", 6, "Canine", "Black", "images/dog.png");
        horse = new Horse("Apollo", 9, "Mustang", "Brown", "images/horse.png");
        bird = new Bird("Bella", 2, "Parrot", "Green", "images/bird.png");

        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        outputStream.reset();
    }

    @Test
    public void testConstructorCreatesEmptyCollections() {
        assertNotNull(circus.getAnimals());
        assertNotNull(circus.getPersons());
        assertNotNull(circus.getBuildings());

        assertTrue(circus.getAnimals().isEmpty());
        assertTrue(circus.getPersons().isEmpty());
        assertTrue(circus.getBuildings().isEmpty());
    }

    @Test
    public void testAddAnimal() {
        circus.addAnimal(dog);

        assertEquals(1, circus.getAnimals().size());
        assertSame(dog, circus.getAnimals().get(0));
    }

    @Test
    public void testAddPerson() {
        Clerk clerk = new Clerk("Maria", 34, 6, "Clerk", "images/clerk.png");
        circus.addPerson(clerk);

        assertEquals(1, circus.getPersons().size());
        assertSame(clerk, circus.getPersons().get(0));
    }

    @Test
    public void testAddBuilding() {
        Arena arena = new Arena("Red", 200.0, 150.0, "images/arena.png");
        circus.addBuilding(arena);

        assertEquals(1, circus.getBuildings().size());
        assertSame(arena, circus.getBuildings().get(0));
    }

    @Test
    public void testSearchAnimalByNameFindsAnimalIgnoringCase() {
        circus.addAnimal(dog);
        circus.addAnimal(horse);

        Animal result = circus.searchAnimalByName("apollo");

        assertSame(horse, result);
    }

    @Test
    public void testSearchAnimalByNameReturnsNullWhenMissing() {
        circus.addAnimal(dog);

        assertNull(circus.searchAnimalByName("Missing"));
    }

    @Test
    public void testSortAnimalsByAgeUsesAscendingOrder() {
        circus.addAnimal(dog);
        circus.addAnimal(horse);
        circus.addAnimal(bird);

        circus.sortAnimalsByAge();

        List<Animal> animals = circus.getAnimals();
        assertEquals("Bella", animals.get(0).getName());
        assertEquals("Zeus", animals.get(1).getName());
        assertEquals("Apollo", animals.get(2).getName());
    }

    @Test
    public void testSortAnimalsByNameUsesAlphabeticalOrder() {
        circus.addAnimal(dog);
        circus.addAnimal(horse);
        circus.addAnimal(bird);

        circus.sortAnimalsByName();

        List<Animal> animals = circus.getAnimals();
        assertEquals("Apollo", animals.get(0).getName());
        assertEquals("Bella", animals.get(1).getName());
        assertEquals("Zeus", animals.get(2).getName());
    }

    @Test
    public void testDisplayAllAnimalsProducesOutput() {
        circus.addAnimal(dog);
        circus.displayAllAnimals();

        assertTrue(outputStream.toString().contains("Zeus"));
    }

    @Test
    public void testDisplayAllPersonsProducesOutput() {
        circus.addPerson(new Clerk(
                "Maria",
                34,
                6,
                "Clerk",
                "images/clerk.png"));

        circus.displayAllPersons();

        assertTrue(outputStream.toString().contains("Maria"));
    }

    @Test
    public void testDisplayAllBuildingsProducesOutput() {
        circus.addBuilding(new Arena(
                "Red",
                200.0,
                150.0,
                "images/arena.png"));

        circus.displayAllBuildings();

        assertTrue(outputStream.toString().contains("Arena"));
    }
}
