package Reshima_Mekusheret;

import unit4.collectionsLib.Node;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * This class contains functions to work with a linked list of integers,
 * including summing up elements, creating a list, and printing its contents.
 */
public class Matala_28 {
       public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{5, 5, 15, 5, 5, 25}); // Example list
        System.out.println("Sum of list elements: " + sumOfList(list));
        printList(list);
    }

    /**
     * Calculates the sum of all elements in a linked list of integers.
     *
     * Complexity:
     * - Time complexity: O(n), where n is the number of nodes in the linked list. Each node is visited once.
     * * @param head the head node of the linked list
     * @return the sum of all integers in the list
     */
    public static int sumOfList(Node<Integer> head) {
        int sum = 0;
        Node<Integer> current = head;

        while (current != null) {
            sum += current.getValue(); // Add the value of the current node
            current = current.getNext(); // Move to the next node
        }

        return sum; // Return the total sum
    }

    /**
     * Creates a linked list of integers from an array.
     * @param values an array of integers to be converted into a linked list
     * @return the head node of the created linked list
     */
    public static Node<Integer> createList(int[] values) {
        Node<Integer> head = null;
        Node<Integer> current = null;

        for (int value : values) {
            if (head == null) {
                head = new Node<>(value);
                current = head;
            } else {
                current.setNext(new Node<>(value));
                current = current.getNext();
            }
        }

        return head;
    }

    /**
     * Prints the elements of a linked list of integers.
     * @param head the head node of the linked list
     */
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
}
