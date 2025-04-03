import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        //came with the file
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);

        //My 10 Buildings

        //Cafe (2)
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive Nothampton, MA 01063", 1);
        myMap.addBuilding(compassCafe);
        compassCafe.sellCoffee(12);
        myMap.addBuilding(new Cafe("CC", "100 Elm Street Northampton, MA 01063", 1, 100, 12, 6, 300));
        
        //House (6)
        myMap.addBuilding(new House());
        myMap.addBuilding(new House("Tyler"));
        myMap.addBuilding(new House("Gillett", "54 Elm Street Northampton, Ma 01063", 5, true, true));
        myMap.addBuilding(new House("Washburn"));
        myMap.addBuilding(new House("Northrop"));
        myMap.addBuilding(new House("Lamont"));

        //Library (2)
        myMap.addBuilding(new Library("Neilson"));
        Library forbes = new Library("Forbes", "20 West Street Northampton, MA 01063", 3, true);
        myMap.addBuilding(forbes);
        forbes.addTitle("Spellbound by F.T Lukens");
        forbes.addTitle("You Should Be So Lucky by Cat Sebastain");
        forbes.printCollection(true);
        forbes.printCollection(false);

        //Check map
        System.out.println(myMap);
    }
    
}
