package BinNode;
import unit4.collectionsLib.BinNode;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5


public class bn_Matala44 {
    public static void main(String[] args) {
        createOkevList(5);
        printList(createOkevList(5));
        printRightList(createOkevList(5));
    }
    /**
     * Constructs and returns a doubly linked list containing integers from `n`
     * to `1` in reverse order.
     * @param n A positive integer. The function generates a doubly linked list with values from `n` to `1`.
     * @return The head of the doubly linked list.
     * Complexity: O(n)
     */
    public static BinNode<Integer> createOkevList(int n) {
        // Constructing a doubly linked list of consecutive integers from 1 to `n`.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 1; i <= n; i++) {
            BinNode<Integer> newNode = new BinNode<>(i); // Create a new node
            if (head == null) {
                head = newNode; // If it's the first node, it becomes the head
                current = head;
            } else {
                current.setRight(newNode); // Set the next node
                newNode.setLeft(current);  // Set the previous node
                current = newNode;        // Move to the new node
            }
        }
        return head; // Return the head of the list
    }

    /**
     * Prints the doubly linked list from the head to the end in left-to-right order.
     *
     * @param head The head of the doubly linked list to be printed.
     */
    public static void printList(BinNode<Integer> head) {
        // Printing the list
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) { // Check if there is a next node
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Move to the next node
        }
        System.out.println(); // Print a newline after the list
    }

    /**
     * Prints the doubly linked list in reverse order (right-to-left), starting from the last node.
     *
     * @param head The head of the doubly linked list to be printed.
     */
    public static void printRightList(BinNode<Integer> head) {
        // Find the end of the list
        BinNode<Integer> current = head;        // Create a pointer
        while (current.getRight() != null) {    // Traverse to the last node
            current = current.getRight();
        }

        // Print values in reverse order
        while (current != null) { // Print values from the end to the beginning
            System.out.print(current.getValue());
            if (current.getLeft() != null) { // Check if there is a previous node
                System.out.print(" <-> ");
            }
            current = current.getLeft();
        }
        System.out.println(); // Print a newline after the list
    }
}
