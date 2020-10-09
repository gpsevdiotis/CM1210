// Georgios Psevdiotis
// C1841824


public class TestPet {
    public static void main(String[] args){

        System.out.println("Pets\n");
		

        Boxer Rocky = new Boxer("Rocky",3,"male",22.3,"brown");
        Rocky.Speak();
		Rocky.setAggressive(true);
        Rocky.eat();
        Rocky.Bark();
        
		
		System.out.println("\n");
		
        Pug Pugface = new Pug("Pugface",9,"male",18, "black");
        Pugface.Speak();
        Pugface.Bark();
        Pugface.fetch();
        Pugface.eat();
        Pugface.Snore();

        System.out.println("\n");

		Cat Sammy = new Cat("Sammy",2,"female",7.2,"grey");
        Sammy.setHouseCat(true);
        Sammy.Speak();
        Sammy.purr();
        Sammy.meow();
        
		System.out.println("\n");

        PufferFish Bloat = new PufferFish("Bloat",1,"male",0.2,"yellow");
        Bloat.Speak();
        Bloat.puff();
        Bloat.swim();

       System.out.println("\n");

           

    }
}
