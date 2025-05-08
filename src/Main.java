import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    HashTable table = new HashTable();

    System.out.println("Entering values:");
    table.put("Sense and Sensibility", "Jane Austen");
    table.put("Jane Eyre", "Charlotte Bronte");
    table.put("Frankenstein", "Mary Shelley");

    System.out.println("Getting values:");
    System.out.println(table.get("Sense and Sensibility"));
    System.out.println(table.get("Jane Eyre"));
    System.out.println(table.get("Frankenstein"));
    System.out.println(table.get("Robinson Crusoe"));
    System.out.println(table.get("Robimson Crusoe"));

    HashMap<String, String> javaHashMap = new HashMap<>();

    javaHashMap.put("Sense and Sensibility", "Jane Austen");
    javaHashMap.put("Jane Eyre", "Charlotte Bronte");
    javaHashMap.put("Frankenstein", "Mary Shelley");

    System.out.println(javaHashMap.get("Sense and Sensibility"));
    System.out.println(javaHashMap.get("Jane Eyre"));
    System.out.println(javaHashMap.get("Frankenstein"));
  }
}