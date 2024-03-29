/**
 * (a)import java util
 */
import java.util.*;
/**
 * Write a description of class Anagram here.
 *Explores the treemap and the treeset classes
 * @author Declan James Cronin
 * @version V0.1
 */

/**
 * (a)In this implementation, the Anagram class includes a public TreeMap field named anagrams, where each key is a word, 
 * and the corresponding value is a TreeSet containing valid anagrams of that word. 
 */
public class Anagram {

    // Public TreeMap field to store words and their anagrams
    public TreeMap<String, TreeSet<String>> anagrams;

    /**
     * (b)zero-argument constructior
     */
    // Zero-argument constructor to initialize the TreeMap
    public Anagram() {
        anagrams = new TreeMap<>();
    }

    /**
     * (c)adds a public zero-parameter method, the method has two sample (key-values) The method does not return a value.
     */
    // Public method to populate the map with sample entries
    public void populate() {
        // Sample entries
        String key1 = "list";
        TreeSet<String> value1 = new TreeSet<>(Arrays.asList("silt", "slit"));

        String key2 = "saps";
        TreeSet<String> value2 = new TreeSet<>(Arrays.asList("asps", "pass", "spas"));

        // Put the sample entries into the map
        anagrams.put(key1, value1);
        anagrams.put(key2, value2);
    }

    /**
     * (d)create a public method of the Anagram class, call's the populate method to add sample entries, and then use the print method to display the map entries 
        */
    // Public method to print the map entries
    public void print() {
        for (Map.Entry<String, TreeSet<String>> entry : anagrams.entrySet()) {
            // Print key followed by a space, a dash, and a space
            System.out.print(entry.getKey() + " - ");

            // Print anagrams associated with the key
            for (String anagram : entry.getValue()) {
                System.out.print(anagram + " ");
            }

            // Print a new line for the next entry
            System.out.println();
        }
    }
 
    


    /**
     * (e) Method that checks whether its two parameters are anagrams of each other. Returns true if the two parameters are anagrams and false otherwise.
     */
    // Public method to check if two words are anagrams
    public boolean areAnagrams(String aWord, String anotherWord) {
        // Check if the lengths of the words are the same
        if (aWord.length() != anotherWord.length()) {
            return false;
        }

        // Convert the words to lowercase for case-insensitive comparison
        aWord = aWord.toLowerCase();
        anotherWord = anotherWord.toLowerCase();

        // Create lists containing the sorted characters of each word
        List<Character> sortedA = new ArrayList<>(aWord.length());
        List<Character> sortedB = new ArrayList<>(anotherWord.length());

        for (char c : aWord.toCharArray()) {
            sortedA.add(c);
        }

        for (char c : anotherWord.toCharArray()) {
            sortedB.add(c);
        }

        // Sort the lists
        Collections.sort(sortedA);
        Collections.sort(sortedB);

        // Compare the sorted lists for equality
        return sortedA.equals(sortedB);
    }

    /**
     * (f) Method that adds a new entry to the anagrams map,checks if aWord already exists as a key in the anagrams map. 
     * If it does, the method retrieves the set associated with the key and adds anAnagram to it. 
     * If aWord doesn't exist as a key, a new map entry is created with aWord
     */
    // Public method to add a new entry to the anagrams map
    public void addAnagram(String aWord, String anAnagram) {
        // Check if the two parameters are anagrams
        if (areAnagrams(aWord, anAnagram)) {
            // Convert both words to lowercase for case-insensitive comparison
            aWord = aWord.toLowerCase();

            // Check if aWord already exists as a key in the anagrams map
            if (anagrams.containsKey(aWord)) {
                // Retrieve the set corresponding to the key and add anAnagram to it
                TreeSet<String> anagramSet = anagrams.get(aWord);
                anagramSet.add(anAnagram);
            } else {
                // Create a new map entry with aWord as the key and a set containing anAnagram as the value
                TreeSet<String> newAnagramSet = new TreeSet<>();
                newAnagramSet.add(anAnagram);
                anagrams.put(aWord, newAnagramSet);
            }
        }
        // If the two parameters are not anagrams, no action is taken
    }

    /**
     * (g) public method, this method changes the anagram map so that each anagram is cross-referenced with every other angram
     */
// Public method to cross-reference each anagram with every other anagram
public void crossReference() {
    // Create a new TreeMap to store the cross-referenced anagrams
    TreeMap<String, TreeSet<String>> crossReferencedAnagrams = new TreeMap<>(anagrams);

    // Iterate through each entry in the original anagrams map
    for (Map.Entry<String, TreeSet<String>> entry : anagrams.entrySet()) {
        String key = entry.getKey();
        TreeSet<String> value = entry.getValue();

        // Iterate through each anagram in the set
        for (String anagram : value) {
            // Skip the current key to avoid adding it to its own set
            if (!anagram.equals(key)) {
                // Check if the anagram already exists as a key in the crossReferencedAnagrams map
                if (crossReferencedAnagrams.containsKey(anagram)) {
                    // Retrieve the set corresponding to the key and add all elements from the original set
                    crossReferencedAnagrams.get(anagram).addAll(value);
                } else {
                    // Create a new map entry with the anagram as the key and a set containing all elements from the original set
                    crossReferencedAnagrams.put(anagram, new TreeSet<>(value));
                }
            }
        }
    }

    // Update the original anagrams map with the cross-referenced anagrams
    anagrams = crossReferencedAnagrams;
}

}