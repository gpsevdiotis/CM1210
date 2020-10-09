// Georgios Psevdiotis
// C1841824

public class Pet {

    String name;
    int age;
    String gender;
    double weightKgs;
    String colour;


    public Pet(String name, int age, String gender, double weightKgs, String colour) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weightKgs = weightKgs;
        this.colour = colour;
    }

    public void eat() {
        System.out.println("I love eating food");
    }

    

}
