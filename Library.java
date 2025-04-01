import java.util.Hashtable;

public class Library extends Building{

  // Atributes
  private Hashtable<String, Boolean> collection;

    /**
     * Constructor
     * @param name
     * @param address
     * @param nFloors
     */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
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
   * Main
   * @param args
   */
  public static void main(String[] args) {
    Library koebel = new Library("Koebel", "5955 S Holly St", 2);
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
  }
  
  }