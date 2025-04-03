import java.util.Hashtable;

public class Library extends Building{

  // Atributes
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    /**
     * Constructor
     * @param name
     * @param address
     * @param nFloors
     */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.hasElevator = hasElevator;
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Method
   * @param title being added
   */
  public void addTitle(String title){
    // because libraries often have multiple copies of books it doesn't throw an expection if the book is already a part of the library
    collection.put(title, true);
  }

  /**
   * Method
   * @param title being added
   * @param copies being added
   */
  public void addTitle(String title, int copies){
    for(int i = 0; i < copies; i++){
      collection.put(title, true);
    }
  }
  
  /**
   * Method
   * @param title being removed
   * @return title being removed
   */
  public String removeTitle(String title){
    if(!collection.containsKey(title)){
      throw new RuntimeException("Book not in Library");
    } else {
      collection.remove(title);
      return title;
    }
  }

    /**
     * Method
     * @param title being checked out
     */
  public void checkOut(String title){
    if(collection.containsKey(title)){
      if(collection.containsValue(true)){
        collection.put(title, false);
      } else {
        throw new RuntimeException("This book is already checked out");
      }
    } else{
      throw new RuntimeException("This book is not at this library");
    }
  }

    /**
     * Method
     * @param title being returned
     */
  public void returnBook(String title){
    if(collection.containsKey(title)){
      if(collection.containsValue(false)){
        collection.put(title, true);
      } else {
        throw new RuntimeException("This book has already been returned");
      }
    } else{
      throw new RuntimeException("This book is not at this library");
    }
  }

  /**
   * Accessor
   * @param title your looking for in the library
   * @return if the title is in the library
   */
  public boolean containsTitle(String title){
    if(collection.containsKey(title)){
      return true;
    } else {
      return false;
    }
  }

    /**
     * Accessor
     * @param title your looking for in the library
     * @return if the title is avaible in the library
     */
  public boolean isAvailable(String title){
    if(collection.containsKey(title)){
      if(collection.containsValue(true)){
        return true;
      } else {
      return false;
      }
    } else {
      throw new RuntimeException("This book is not at this Library");
    }
  }

  /**
   * Method that prints collection
   */
  public void printCollection(){
    System.out.println("The following books are in the library: ");
    for (String title : collection.keySet()){
      boolean available = collection.get(title);
      System.out.println(title + " is available: " + available);
    }
  }

  /**
   * Method to show options
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle(title) \n + removeTitle(title) \n + checkOut(title) \n + returnBook(title) \n + containsTitle(title) \n + isAvailable(title) \n + printCollection()");
}

/**
 * Method to move up and down floors
 * @param floorNum the floor you want to go to
 */
public void goToFloor(int floorNum) {
  if (this.activeFloor + 1 < floorNum || this.activeFloor - 1 > floorNum) {
    if(!hasElevator){
      throw new RuntimeException("No elevator. Can only move up one or down one floor at a time");
    }
  }
  super.goToFloor(floorNum);
}
  
  /**
   * Main
   * @param args
   */
  public static void main(String[] args) {
    Library koebel = new Library("Koebel", "5955 S Holly St", 3, true);
    Library tinyShackInWoods = new Library("Tiny Shack in the Woods", "Really?", 6, false);
    koebel.addTitle("Six of Crows by Leigh Bardugo");
    koebel.addTitle("Crooked Kingdom by Leigh Bardugo");
    koebel.addTitle("I Kissed Shara Wheeler by Casey McQuinston");
    System.out.println(koebel.removeTitle("Crooked Kingdom by Leigh Bardugo"));
    koebel.checkOut("Six of Crows by Leigh Bardugo");
    System.out.println(koebel.isAvailable("Six of Crows by Leigh Bardugo"));
    koebel.printCollection();
    koebel.returnBook("Six of Crows by Leigh Bardugo");
    System.out.println(koebel.isAvailable("Six of Crows by Leigh Bardugo"));
    System.out.println(koebel.containsTitle("Six of Crows by Leigh Bardugo"));
    System.out.println(koebel.containsTitle("Crooked Kingdom by Leigh Bardugo"));
    koebel.printCollection();
    koebel.showOptions();
    koebel.enter();
    koebel.goToFloor(3);
    tinyShackInWoods.enter();
    tinyShackInWoods.goUp();
    tinyShackInWoods.goUp();
    tinyShackInWoods.goUp();
    tinyShackInWoods.goToFloor(2);
  }
  
  }