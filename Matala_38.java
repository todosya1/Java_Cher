import unit4.collectionsLib.Node;
import java.util.Scanner;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * This class contains a function that creates a sorted linked list from user input.
 * The function uses insertSorted from Matala_37 to maintain the sorted order.
 */
public class Matala_38 {
    public static void main(String[] args) {

        Node<Integer> sortedList = createSortedList();
        System.out.println("\nSorted list:");
        Matala_37.printList(sortedList);
    }
    /**
     * Creates a sorted linked list from user input.
     * Reads integers until a number greater than 99 is entered.
     * Uses insertSorted from Matala_37 to maintain the sorted order.
     * Сomplexity: O(n²)
     * @return head of the sorted linked list
     */
    public static Node<Integer> createSortedList() {
        Scanner scanner = new Scanner(System.in);
        Node<Integer> head = null;
        
        System.out.println("Enter numbers (enter number > 99 to finish):");
        
        while (true) {
            int number = scanner.nextInt();
            if (number > 99) {
                break;
            }
            head = Matala_37.insertSorted(head, number);
        }
        
        return head;
    }
    

}