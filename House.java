import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {

  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom;
  }

  /** Accessor for hasDiningRoom */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /** Accessor for number of residents */
  public int nResidents() {
    return this.residents.size();
  }

  public void moveIn(String name) {
    // check if this.residents contains name
    if (this.residents.contains(name)) {
      //   if so: throw an exception
      throw new RuntimeException(name + " is already a resident of " + this.name);
    }
    // if we're good to go, add to roster
    this.residents.add(name);
    System.out.println(name + " has just moved into " + this.name + "! Go say hello :)");
  }

  public String moveOut(String name){
    // return the name of the person who moved out
    if (this.residents.contains(name)){
      System.out.println(name);
      this.residents.remove(name);
    } else {
      throw new RuntimeException(name + " has already moved out!");
    }
    return this.name;
  }

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + moveOut()\n + moveIn()\n + hasDiningRoom()\n + order live and have fun!");
    }

  public boolean isResident(String person){
      /* tells us whether or not a given person is a resident of the `House` */
      if (this.residents.contains(person)){
        return true;
      } else {
        return false;
      }
      
    }

  public String toString() {
    String description = super.toString();
    description += " There are currently " + this.nResidents() + " people living in this house.";
    description += " This house ";
    if (this.hasDiningRoom) {
      description += "has";
    } else {
      description += "does not have";
    }
    description += " an active dining room.";
    return description;
  }

  public static void main(String[] args) {
    House morrow = new House("Morrow", "The Quad", 4, false);
    System.out.println(morrow);
    morrow.moveIn("Jordan");
    morrow.moveIn("Jordan");
    System.out.println(morrow);
    House king = new House("King", "The Quad", 3, true);
    System.out.println(king);
  }

}