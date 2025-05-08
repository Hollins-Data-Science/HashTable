import java.util.LinkedList;
import java.util.ArrayList;

/*
This class implements a String->String hash table.
The hash table uses linked lists to handle collisions.
*/

public class HashTable {
  class Entry {
    String key;
    String value;

    Entry(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity = 16;
  private ArrayList<LinkedList<Entry>> table;

  HashTable() {
    table = new ArrayList<>(capacity);
    for (int i = 0; i < capacity; i++) {
      table.add(null);
    }
  }

  // Return a hashed postion in the table
  private int hash(String key) {
    int hashVal = 1;

    for (int i = 0; i < key.length(); i++) {
      hashVal = hashVal * 5 + (int) key.charAt(i);
    }
    System.out.printf("Hash value:%d%n", hashVal);
    System.out.printf("Hash value after modulo:%d%n", hashVal % capacity);

    return hashVal % capacity;
  }

  public void put(String key, String value) {
    int hashVal = hash(key);
    LinkedList<Entry> currentList = table.get(hashVal);

    if (currentList == null) {
      // Add a list at this position
      LinkedList<Entry> newList = new LinkedList<>();
      newList.add(new Entry(key, value));
      table.set(hashVal, newList);
    } else {
      // Check the list for the key
      for (Entry entry : currentList) {
        if (entry.key.equals(key)) {
          // Found the key
          entry.value = value;
          return;
        }
      }
      // Didn't find the key
      currentList.add(new Entry(key, value));
    }
  }

  public String get(String key) {
    int hashVal = hash(key);
    LinkedList<Entry> currentList = table.get(hashVal);
    if (currentList != null) {
      // Check the list for our key
      for (Entry entry : currentList) {
        if (entry.key.equals(key)) {
          // Found it
          return entry.value;
        }
      }
    }
    // Didn't find it
    return null;
  }

}