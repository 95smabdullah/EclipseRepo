package day4.hthm;

import java.util.Hashtable;

public class HashtableIterationExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");

        // Without external synchronization, concurrent modifications can lead to issues
        for (Integer key : hashtable.keySet()) {
            if (key == 2) {
                hashtable.remove(3); // Concurrent modification
            }
            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
        }
    }
}

