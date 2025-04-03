import java.util.ArrayList;

public class House extends Building {

  //Atributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Contructor
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Contructor
   * @param name
   */
  public House(String name) {
    this.name = name;
    this.address = "No address found";
    this.nFloors = 1;
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Contructor
   * @param name
   */
  public House() {
    this.name = "Unknown";
    this.address = "No address found";
    this.nFloors = 1;
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

/**
 * Accessor
 * @return if the house has dining room
 */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

/**
 * Acessor
 * @return the number of residents
 */
  public int nResidents(){
    return residents.size();
  }

/**
 * Method
 * @param s the student moving in
 */
  public void moveIn(Student s){
    if(residents.contains(s)){
      throw new RuntimeException("Student already in this House");
    } else{
    residents.add(s);
    }
  }

  /**
   * Method
   * @param s the student moving out
   * @return s the student moving out
   */
  public Student moveOut(Student s){
    if(!residents.contains(s)){
      throw new RuntimeException("Student not in this House");
    } else{
      residents.remove(s);
      return s;
    }
  }

    /**
     * Method
     * @param s the student you are wondering is a resident
     * @return if they are a resident or not
     */
  public boolean isResident(Student s){
    if(residents.contains(s)){
          return true;
      } else{
        return false;
      }
  }

  /**
   * Method to show options
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + moveIn(s) \n + moveOut(s) \n");
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
   * To String
   * @return the name and if it has a dining room
   */
  public String toString(){
    return this.name + " house has a dining room : " + this.hasDiningRoom;
  }

  /**
   * Main
   * @param args
   */
  public static void main(String[] args) {
    House gillett = new House("Gillett", "54 Elm", 5, true, true);
    House washburn = new House("Washburn", "Green St", 3, false, false);
    System.out.println(gillett);
    System.out.println(gillett.hasDiningRoom());
    System.out.println(gillett.nResidents());
    Student catherine = new Student("Catherine", "9923094", 2027);
    gillett.moveIn(catherine);
    System.out.println(gillett.isResident(catherine));
    gillett.moveOut(catherine);
    System.out.println(gillett.isResident(catherine));
    gillett.enter();
    gillett.goToFloor(4);
    gillett.showOptions();
    washburn.enter();
    washburn.goToFloor(3);
  }
}