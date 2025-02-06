package Reshima_Mekusheret;

import unit4.collectionsLib.Node;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * Write a function that takes a linked list of integers and 
 * a positive integer n. The function should return true 
 * if there exists a sequence of n consecutive numbers in the list.
 * (The sequence can be either ascending or descending).
 */
public class Matala_40 {

    public static void main(String[] args) {
        int testArr[] = {1, 2, 3, 4, 77, 5, 6, 7, 0, 9, 10};
        Node<Integer> list = createList(testArr);
        printList(list);
        int num = 5;
        System.out.println("List has " + num + " sequences: " + checkListSequence(list, num));
        num = 4;
        System.out.println("List has " + num + " sequences: " + checkListSequence(list, num));
        System.out.println();
    }

    /**
     * Checks for a sequence of n consecutive numbers in the list
     * Complexity O(n²)
     * @param head start of the list
     * @param n length of the desired sequence
     * @return true if a sequence of n consecutive numbers is found
     */
    public static boolean checkListSequence(Node<Integer> head, int n) {
        if (head == null || n <= 0) return false; // check for empty list and negative n
        if (n == 1) return true; // check for sequence of one number

        Node<Integer> current = head;
        while (current != null && current.getNext() != null) {
            // Check ascending sequence
            if (checkSequence(current, n, true)) return true;
            // Check descending sequence
            if (checkSequence(current, n, false)) return true;
            current = current.getNext();
        }
        return false;
    }

    /**
     * Helper function - checks for a sequence starting from the current node
     * @param start starting node
     * @param num required sequence length
     * @param ascending true for ascending, false for descending sequence
     * @return true if sequence is found
     */
    private static boolean checkSequence(Node<Integer> start, int num, boolean ascending) {
        if (start == null) return false; // check for empty list

        Node<Integer> current = start; // create pointer to starting node
        int count = 1;
        int prev = current.getValue();

        while (current.getNext() != null && count < num) {
            current = current.getNext();
            int curr = current.getValue();

            if (ascending && curr == prev + 1) {
                count++;
                prev = curr;
            } else if (!ascending && curr == prev - 1) {
                count++;
                prev = curr;
            } else {
                break;
            }
        }

        return count == num;
    }

    /**
     * Helper method for creating a linked list from an array
     */
    public static Node<Integer> createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.setNext(new Node<>(arr[i]));
            current = current.getNext();
        }

        return head;
    }

    /**
     * Helper method for printing the list
     */
    public static void printList(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}