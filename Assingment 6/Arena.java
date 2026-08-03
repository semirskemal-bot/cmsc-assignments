package BobsCircus;
/** Represents the circus arena building. */
public class Arena implements Building {
    private String color;
    private double length;
    private double width;
    private String buildingType;
    private String imagePath;
    
    // All argument Constructor 
    public Arena(String color, double length, double width, String imagePath) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Arena";
        this.imagePath = imagePath;
    }
    // assigns size via length and width
    @Override
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }
    // returns the length of Arena
    @Override public double getLength() { 
    	return length; 
    	}
    //returns width of Arena
    @Override public double getWidth() {
    	return width;
    	}
    //Assigns color of Arena
    @Override public void setColor(String color) {
    	this.color = color; 
    	}
    //Returns color of Arena
    @Override public String getColor() {
    	return color; 
    	}
    //Assigns the arena's building type
    @Override public void setBuildingType(String type) {
    	this.buildingType = type;
    	}
    //Returns the arena's building type
    @Override public String getBuildingType() {
    	return buildingType; 
    	}
    // Returns the arena's image path
    @Override public String getImagePath() {
    	return imagePath;
    	}
    // returns Arena details as a string.
    @Override
    public String toString() {
        return String.format("\nBuilding Type: %s \nColor: %s \nSize: %.1f x %.1f\n",
                buildingType, color, length, width);
    }
}
