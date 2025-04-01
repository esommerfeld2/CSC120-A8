public class Cafe extends Building {

    //Atributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces= nCoffeeOunces;
        this.nSugarPackets= nSugarPackets;
        this.nCreams= nCreams;
        this.nCups= nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method
     * @param size of coffee
     * @param nSugarPackets in coffee
     * @param nCreams in coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        
        //Coffee
        if(this.nCoffeeOunces< size){
            restock(12, 0,0,0);
            this.nCoffeeOunces -= size;
        } else {
            this.nCoffeeOunces -= size; 
        } 

        //Sugar
        if(this.nSugarPackets < nSugarPackets){
            restock(0,10,0,0);
            this.nSugarPackets -= nSugarPackets;
        } else {
            this.nSugarPackets -= nSugarPackets;
        }

        //Cream
        if(this.nCreams < nCreams){
            restock(0,0,10,0);
            this.nCreams -= nCreams;
        } else {
            this.nCreams -= nCreams;
        }

        //Cups
        if(this.nCups < 1) {
            restock(0,0,0,10);
            this.nCups -= 1;
        } else {
            this.nCups -= 1;
        }
    }

    /**
     * Method
     * @param nCoffeeOunces to restock
     * @param nSugarPackets to restock
     * @param nCreams to restock
     * @param nCups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * To String
     * @return the coffee, sugar, cream, and cups available
     */
    public String toString() {
        return("We have " + nCoffeeOunces + " oz of coffee, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups.");  
    }
    
    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        Cafe aAndE= new Cafe("AandE", "57312", 3, 12, 1, 1, 2);
        //Testing Constructor 12, 1, 1, 2
        System.out.println(aAndE);
        aAndE.sellCoffee(5,0,0);
        //Testing selling coffee no restock 7,1,1,1
        System.out.println(aAndE);
        //restock cups 2,1,1,10
        aAndE.sellCoffee(5,0,0);
        System.out.println(aAndE);
        //restock coffee 10,1,1,9
        aAndE.sellCoffee(4,0,0);
        System.out.println(aAndE);
        //restock sugar 6,9,1,8
        aAndE.sellCoffee(4,2,0);
        System.out.println(aAndE);
        //restock cream 2,9,9,7
        aAndE.sellCoffee(4,0,2);
        System.out.println(aAndE);
        //last test use all 2, 7, 6, 6
        aAndE.sellCoffee(12,2,3);
        System.out.println(aAndE);
    }
    
}
