package Reshima_Mekusheret;

import unit4.collectionsLib.Node;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

// Write a function that removes consecutive duplicate characters from a linked list

public class Matala_39 {
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
                "aabbcc",      // Should become "abc"
                "aaaa",        // Should become "a"
                "abcd",        // Should remain "abcd"
                "aabbccaa"     // Should become "abca"
        };

        for (int i = 0; i < tests.length; i++) {
            Node<Character> list = createList(tests[i]);
            System.out.println("Original list: " + tests[i]);
            System.out.print("Modified list: ");
            printList(removeConsecutiveDuplicates(list));
            System.out.println();
        }
    }
    /**
     * Removes consecutive duplicate characters from a linked list.
     * Keeps the first character in each sequence and removes the rest.
     * Preserves the order of characters.
     * Time complexity: O(n)
     * @param head head of the character list
     * @return head of the modified list
     */
    public static Node<Character> removeConsecutiveDuplicates(Node<Character> head) {
        // If list is empty or has only one node
        if (head == null || head.getNext() == null) return head;

        Node<Character> current = head; // create pointer
        
        // Traverse the list
        while (current != null && current.getNext() != null) {
            // If current character equals the next one
            if (current.getValue().equals(current.getNext().getValue())) {
                // Skip the next node
                current.setNext(current.getNext().getNext());
            } else {
                // Move to next node only if no duplicate was found
                current = current.getNext();
            }
        }
        
        return head;
    }
    
    /**
     * Helper method to create a linked list of characters from a string
     */
    public static Node<Character> createList(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        
        Node<Character> head = new Node<>(str.charAt(0));
        Node<Character> current = head;
        
        for (int i = 1; i < str.length(); i++) {
            current.setNext(new Node<>(str.charAt(i)));
            current = current.getNext();
        }
        
        return head;
    }
    
    /**
     * Helper method to print the list of characters
     */
    public static void printList(Node<Character> head) {
        Node<Character> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }
}