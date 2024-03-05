

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AnagramTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AnagramTest
{
    // Main method for testing
    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        // Populate and print original anagrams map
        anagram.populate();
        System.out.println("Original Anagrams Map:");
        anagram.print();

        // Add new entry and print updated anagrams map
        anagram.addAnagram("list", "slit");
        System.out.println("\nAnagrams Map after adding 'slit' as an anagram of 'list':");
        anagram.print();

        // Cross-reference anagrams and print updated anagrams map
        anagram.crossReference();
        System.out.println("\nAnagrams Map after cross-referencing:");
        anagram.print();
    }
}

