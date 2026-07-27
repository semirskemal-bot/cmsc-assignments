
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Stores information about a medical procedure,
 * including its name, date, practitioner, and charge.
 * Due: 07/27/2026
 * Platform/Compiler: Java / Eclipse
 *
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student
 * or any source. I have not given my code to any student.
 *
 * Print your Name here: Semir Kemal
 */

public class Procedure {

    private String name;
    private String date;
    private String practitionerName;
    private double charges;

    /**
     * Creates an empty Procedure object.
     */
    public Procedure() {
        name = "";
        date = "";
        practitionerName = "";
        charges = 0.0;
    }

    /**
     * Creates a Procedure object with its name and date.
     *
     * @param name the procedure name
     * @param date the procedure date
     */
    public Procedure(String name, String date) {
        this();

        this.name = name;
        this.date = date;
    }

    /**
     * Creates a Procedure object with all procedure information.
     *
     * @param name             the procedure name
     * @param date             the procedure date
     * @param practitionerName the practitioner's name
     * @param charges          the procedure charge
     */
    public Procedure(
            String name,
            String date,
            String practitionerName,
            double charges) {

        this.name = name;
        this.date = date;
        this.practitionerName = practitionerName;
        this.charges = charges;
    }

    /**
     * Returns the procedure name.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the procedure name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the procedure date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Updates the procedure date.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the practitioner's name.
     */
    public String getPractitionerName() {
        return practitionerName;
    }

    /**
     * Updates the practitioner's name.
     */
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    /**
     * Returns the procedure charge.
     */
    public double getCharge() {
        return charges;
    }

    /**
     * Updates the procedure charge.
     */
    public void setCharge(double charges) {
        this.charges = charges;
    }

    /**
     * Returns all procedure information in a formatted string.
     */
    @Override
    public String toString() {
        return "Procedure: " + name
                + "\nProcedure Date: " + date
                + "\nPractitioner: " + practitionerName
                + String.format("\nCharge: $%,.2f", charges);
    }
}

