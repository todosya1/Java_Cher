package Reshima_Mekusheret;

import unit4.collectionsLib.Node;
// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * This class contains functions to work with a linked list of floating-point numbers,
 * including calculating whether the count of elements above the average equals the count below it.
 */
public class Matala_29 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.5, 2.0, 3.5, 6.0, 7.5, 9.0}); // Example list
        System.out.println("Result: " + isEqualAboveBelowAverage(list));
    }

    /**
     * Checks if the number of elements greater than the average equals the number of elements less than the average
     * in a linked list of floating-point numbers.
     * Time complexity: O(n), where n is the number of nodes in the linked list. The list is traversed twice.
     * @param head the head node of the linked list
     * @return true if the count of elements above the average equals the count below the average, false otherwise
     */
    public static boolean isEqualAboveBelowAverage(Node<Double> head) {
        if (head == null) return false; // Empty list

        // Calculate the average value
        double sum = 0;
        int count = 0;
        Node<Double> current = head;

        while (current != null) {
            sum += current.getValue();
            count++;
            current = current.getNext();
        }

        double average = sum / count;

        // Count elements above and below the average
        int aboveCount = 0;
        int belowCount = 0;
        current = head;

        while (current != null) {
            if (current.getValue() > average) {
                aboveCount++;
            } else if (current.getValue() < average) {
                belowCount++;
            }
            current = current.getNext();
        }

        // Check equality
        return aboveCount == belowCount;
    }

    /**
     * Creates a linked list of floating-point numbers from an array.
     * @param values an array of floating-point numbers to be converted into a linked list
     * @return the head node of the created linked list
     */
    public static Node<Double> createList(double[] values) {
        Node<Double> head = null;
        Node<Double> current = null;
        for (double value : values) {
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
