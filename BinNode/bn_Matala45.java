package BinNode;
import unit4.collectionsLib.BinNode;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5


public class bn_Matala45 {
    public static void main(String[] args) {
        // Create a test doubly linked list
        BinNode<Character> head = createCharList("radar"); // Example: palindrome
        // Check if it is a palindrome
        System.out.println("radar"+(isPalindrome(head) ? " --> is palindrom - TRUE" : " --> is palindrom - FALSE")); // Output should be true
        head = createCharList("hello"); // Example: not a palindrome
        System.out.println("hello"+(isPalindrome(head) ? " --> is palindrom - TRUE" : " --> is palindrom - FALSE")); // Output should be false
    }

    /**
     * Checks if the given doubly linked list forms a palindrome.
     * @param head The head of the doubly linked list.
     * @return `true` if the list is a palindrome, `false` otherwise.
     * Complexity O(n);
     */
    public static boolean isPalindrome(BinNode<Character> head) {
        if (head == null || head.getRight() == null) {
            // An empty list or a list with one element is always a palindrome
            return true;
        }

        // Find the end of the list
        BinNode<Character> left = head;
        BinNode<Character> right = head;
        while (right.getRight() != null) {
            right = right.getRight();
        }

        // Compare characters from both ends moving toward the center
        while (left != right && left.getLeft() != right) {
            if (!left.getValue().equals(right.getValue())) {
                return false; // If characters do not match, it is not a palindrome
            }
            left = left.getRight();  // Move from the start towards the center
            right = right.getLeft(); // Move from the end towards the center
        }

        return true; // The list is a palindrome
    }

    /**
     * Helper method to create a doubly linked list from a string.
     *
     * @param str The string to convert into a doubly linked list of characters.
     * @return The head of the doubly linked list.
     */
    public static BinNode<Character> createCharList(String str) {
        BinNode<Character> head = null;
        BinNode<Character> current = null;

        for (char c : str.toCharArray()) {
            BinNode<Character> newNode = new BinNode<>(c); // Create a new node
            if (head == null) {
                head = newNode; // Set the first node as head
                current = head;
            } else {
                current.setRight(newNode); // Link the next node
                newNode.setLeft(current);  // Link the previous node
                current = newNode;         // Move to the new node
            }
        }

        return head;
    }
}
