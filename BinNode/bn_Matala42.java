package BinNode;
import unit4.collectionsLib.BinNode;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5



public class bn_Matala42 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        BinNode<Integer> bnList = createList(arr);
        printList(createList(arr));

        insertHeadBNlist(bnList, 333);
        printList(bnList);
    }

    /**
     * Inserts a new integer node as the head of a doubly linked list.
     * Updates the existing head to be linked as the next node with its value preserved.
     *
     * @param head the current head of the linked list
     * @param num the integer value to be inserted as the new head
     *
     * Complexity: O(1) (constant time, as operations are limited to the head and its neighbors)
     */
    public static void insertHeadBNlist(BinNode<Integer> head, int num) {
        if (head == null) {
            System.out.println("The list cannot be empty.");
            return;
        }

        // Create a new node 'temp' with the current head's value
        BinNode<Integer> temp = new BinNode<>(head.getValue());

        // Check if the current head has a right node
        if (head.hasRight()) {
            temp.setRight(head.getRight());
            head.getRight().setLeft(temp);
        }

        // Update the head value with 'num' and link it to 'temp'
        head.setValue(num);
        head.setRight(temp);
        head.setLeft(null);

        // Set the 'temp' node's left link to the updated head
        temp.setLeft(head);
    }

    /**
     * Creates a doubly linked list of integers from an array.
     * @param values an array of integers to be converted into a linked list
     * @return the head node of the created linked list
     * Complexity: O(n) (where n is the size of the input array; each element is processed once)
     */
    public static BinNode<Integer> createList(int[] values) {
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int bafer : values) {
            BinNode<Integer> newBinNode = new BinNode<>(bafer); // Create a new node
            if (head == null) {
                head = newBinNode; // If this is the first node, set it as the head
                current = head;
            } else {
                current.setRight(newBinNode); // Link the next node
                newBinNode.setLeft(current);  // Link the previous node (doubly linking)
                current = newBinNode;        // Move to the newly added node
            }
        }
        return head; // Return the head of the list
    }

    /**
     * Prints the linked list from the given head node to the end of the list.
     * Each node value is printed in order, separated by <->.
     *
     * @param head the head node of the linked list to be printed
     *
     * Complexity: O(n) (where n is the number of nodes in the list; each node is visited once)
     */
    public static void printList(BinNode<Integer> head) {
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) { // Check if there's a next node
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Move to the next node
        }
        System.out.println(); // Print a new line after the list
    }

    /**
     * Prints a doubly linked list in reverse, starting from the last node and ending at the head.
     * The list is printed in reverse order, with values separated by <->.
     *
     * @param head the head node of the linked list from which traversal starts
     *
     * Complexity: O(n) (where n is the number of nodes in the list; first traversal to the end, then reversed)
     */
    public static void printRightList(BinNode<Integer> head) {
        BinNode<Integer> current = head;

        // Find the end of the list
        while (current.getRight() != null) { // Look for the last node
            current = current.getRight();
        }

        // Print the values in reverse order
        while (current != null) { // Print nodes from the end to the start
            System.out.print(current.getValue());
            if (current.getLeft() != null) { // Check if there's a previous node
                System.out.print(" <-> ");
            }
            current = current.getLeft(); // Move to the previous node
        }
        System.out.println(); // Print a new line after the list
    }
}
