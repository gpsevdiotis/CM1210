// Georgios Psevdiotis
// C1841824

public class Dog extends Pet {

    private boolean aggressive;

    public Dog(String name, int age, String gender, double weightKgs, String colour) {
        super(name, age, gender, weightKgs,colour);
        this.aggressive = aggressive;
    }

    public boolean isAggressive() {
        return aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    public void Bark() {
        System.out.println("Woof Woof");
    }

    public void fetch() {
        System.out.println("*runs to get it*");
    }

    public void Speak() {
        System.out.print("I am a Dog and my name is "+name+", I weight "+weightKgs+"Kg, I am  "+ age + " years old "+ gender +" and my colour is "+colour+ ".");
        if (isAggressive()){
            System.out.println(" I am aggressive.");
        }
        else {
            System.out.println(" I am not aggressive.");
        }
    }
}
