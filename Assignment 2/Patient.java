
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Stores patient information, including the patient's
 * name, address, phone number, and emergency contact information.
 * Due: 07/27/2026
 * Platform/Compiler: Java / Eclipse
 *
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student
 * or any source. I have not given my code to any student.
 *
 * Print your Name here: Semir Kemal
 */

public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyPhone;

    /**
     * Creates an empty Patient object.
     */
    public Patient() {
        firstName = "";
        middleName = "";
        lastName = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        phoneNumber = "";
        emergencyName = "";
        emergencyPhone = "";
    }

    /**
     * Creates a Patient object with first, middle, and last name.
     *
     * @param firstName  the patient's first name
     * @param middleName the patient's middle name
     * @param lastName   the patient's last name
     */
    public Patient(String firstName, String middleName, String lastName) {
        this();

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * Creates a Patient object with all patient information.
     *
     * @param firstName      the patient's first name
     * @param middleName     the patient's middle name
     * @param lastName       the patient's last name
     * @param address        the patient's street address
     * @param city           the patient's city
     * @param state          the patient's state
     * @param zip            the patient's ZIP code
     * @param phoneNumber    the patient's phone number
     * @param emergencyName  the emergency contact's name
     * @param emergencyPhone the emergency contact's phone number
     */
    public Patient(
            String firstName,
            String middleName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phoneNumber,
            String emergencyName,
            String emergencyPhone) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emergencyName = emergencyName;
        this.emergencyPhone = emergencyPhone;
    }

    /**
     * Returns the patient's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the patient's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the patient's middle name.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Updates the patient's middle name.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Returns the patient's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the patient's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the patient's street address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the patient's street address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the patient's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Updates the patient's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Returns the patient's state.
     */
    public String getState() {
        return state;
    }

    /**
     * Updates the patient's state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Returns the patient's ZIP code.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Updates the patient's ZIP code.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Returns the patient's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Updates the patient's phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the emergency contact's name.
     */
    public String getEmergencyName() {
        return emergencyName;
    }

    /**
     * Updates the emergency contact's name.
     */
    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    /**
     * Returns the emergency contact's phone number.
     */
    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    /**
     * Updates the emergency contact's phone number.
     */
    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    /**
     * Builds the patient's full name.
     *
     * @return first, middle, and last name separated by spaces
     */
    public String buildFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    /**
     * Builds the patient's complete address.
     *
     * @return address, city, state, and ZIP separated by spaces
     */
    public String buildAddress() {
        return address + " " + city + " " + state + " " + zip;
    }

    /**
     * Builds the emergency contact information.
     *
     * @return emergency contact name and phone separated by a space
     */
    public String buildEmergencyContact() {
        return emergencyName + " " + emergencyPhone;
    }

    /**
     * Returns all patient information in a formatted string.
     */
    @Override
    public String toString() {
        return "Name: " + buildFullName()
                + "\nAddress: " + buildAddress()
                + "\nPhone Number: " + phoneNumber
                + "\nEmergency Contact: " + buildEmergencyContact();
    }
}

