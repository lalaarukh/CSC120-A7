import java.util.Hashtable;

/* This is a stub for the Library class */

public class Library extends Building {
  private Hashtable<String, Boolean> collection;

  /* constructor for library */
    public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

  /* method to add title to collection and print what you added */
  public void addTitle(String title){
    Boolean isavailable = collection.get(title);
    //if title is already in hashtable, throw runtime exception
    if(isavailable){
      throw new RuntimeException("This book already exists in collection!");
    } else {
      collection.put(title, true);
    }
  }

  /* method to remove title from collection and print what you removed */
  public String removeTitle(String title){
    Boolean isavailable = collection.get(title);
    //if title is not in collection, throw runtime exception
    if(isavailable){
      collection.remove(title);
      System.out.println(title + " is now removed!");
    } else {
      throw new RuntimeException("This book is not in the collection");
    }

  }
  
  /* method to check out a book from the collection */
  public void checkOut(String title){
    Boolean isavailable = collection.get(title);
    if(isavailable){
      collection.put(title, false);
    } else {
      throw new RuntimeException("Sorry! We dont have this book. Try again another time!");
    }
  }

  /* method to return book */
  public void returnBook(String title){
    Boolean isavailable = collection.get(title);
    if(!isavailable){
      collection.put(title, true);
    } else {
      throw new RuntimeException("You can't return this right now, sorry!");
    }
  }

  /* returns true if the title appears as a key in the Libary's collection, false otherwise */
  public boolean containsTitle(String title){
     if(collection.containsKey(title)){
      return true;
     } else {
      return false;
     }
  }

/* returns true if the title is currently available, false otherwise */
  public boolean isAvailable(String title){
    Boolean isavailable = collection.get(title);
    if(isavailable){
      return true;
    } else {
      return false;
    }
  } 
  
  /* prints out the entire collection in an easy-to-read way (including checkout status) */
  public void printCollection(){
    for(String key : collection.keySet()){
      Boolean value = collection.get(key);
      System.out.println(key + value);
    }
  }
    public static void main(String[] args) {
      new Library();
    }

  }