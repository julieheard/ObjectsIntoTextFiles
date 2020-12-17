
package objectsintofiles;

import java.io.Serializable;
public class cat implements Serializable{

    private String name;
    private String colour;
    private int age;

    public cat(String name, String Colour, int age) {
        this.name = name;
        this.colour = Colour;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColour(String Colour) {
        this.colour = Colour;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
		return name + ","+ colour +","+ age; // Turns object into CSV
    }
    
}