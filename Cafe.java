import javax.management.RuntimeErrorException;

/* This is a stub for the Cafe class */
public class Cafe extends Building {
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups;
   

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    /* decrease inventory in each category according to the given parameters */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nCups){
        if (size < this.nCoffeeOunces || nSugarPackets < this.nSugarPackets || nCreams < this.nCreams){
         this.nCoffeeOunces = this.nCoffeeOunces - size;
         this.nSugarPackets = this.nSugarPackets - nSugarPackets;
         this.nCreams = this.nCreams - nCreams;
         this.nCups = this.nCups - nCups;
         System.out.println("We have" + nCoffeeOunces + "coffee ounces, " + nSugarPackets + "sugar packets, " + nCreams + "creams, and" + nCups + "cups remaining!");   
        } else {
            System.out.println("Sorry, we do not have the inventory to make your drink, let us restock");
            Cafe.restock(20, 20, 20, 20);
        }
    
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;

        /*This method will be `private` (since we don't want some random person forcefully restocking the shelves!) 
        - we'll call it from **inside** the `sellCoffee(...)` method, in the event that we don't have enough 
        ingredients in stock to make the requested drink. */
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + order coffee!");
    }
    public static void main(String[] args) {
        new Cafe();
    }
    
}