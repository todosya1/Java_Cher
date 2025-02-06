package Reshima_Mekusheret;

import unit4.collectionsLib.Node;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * This class contains functions to work with a linked list of integers,
 * including checking if the elements are sorted in ascending order.
 */
public class Matala_30 {
       public static void main(String[] args) {
        Node<Integer> list1 = createList(new int[]{1, 2, 3, 4, 5}); // Ordered list
        Node<Integer> list2 = createList(new int[]{1, 3, 0, 4, 5}); // Unordered list

        System.out.println("List 1 is in ascending order: " + isAscending(list1));
        System.out.println("List 2 is in ascending order: " + isAscending(list2));
    }

    /**
     * Checks if the elements in a linked list are sorted in ascending order.
     * complexity: O(n), where n is the number of nodes in the linked list. Each node is visited once.
     * @param head the head node of the linked list
     * @return true if the elements are sorted in ascending order, false otherwise
     */
    public static boolean isAscending(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true; // An empty list or a list with one element is considered sorted
        }

        Node<Integer> current = head;

        while (current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue()) {
                return false; // Found a violation of ascending order
            }
            current = current.getNext();
        }

        return true; // All elements are sorted in ascending order
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
}
