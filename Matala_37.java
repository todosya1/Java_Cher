import unit4.collectionsLib.Node;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5


public class Matala_37 {
    /**
     * Inserts a number into a sorted linked list while maintaining the sorting order
     * @param head head of the sorted list
     * @param number number to insert
     * @return head of the list (may change if the new number is smaller than the first element)
     */
    public static Node<Integer> insertSorted(Node<Integer> head, int number) {
        Node<Integer> newNode = new Node<>(number);
        
        // If the list is empty or the new number is smaller than the first element
        if (head == null || head.getValue() >= number) {
            newNode.setNext(head);
            return newNode;
        }
        
        // Find the correct position for insertion
        Node<Integer> current = head;
        while (current.getNext() != null && current.getNext().getValue() < number) {
            current = current.getNext();
        }
        
        // Insert the new node
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        
        return head;
    }
    
    /**
     * Helper function to print the list
     * @param head head of the list
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
    
    /**
     * Helper function to create a test list
     * @param values array of values to create the list from
     * @return head of the created list
     */
    public static Node<Integer> createTestList(int[] values) {
        Node<Integer> head = null;
        for (int value : values) {
            head = insertSorted(head, value);
        }
        return head;
    }
    
    public static void main(String[] args) {
        // Create a test sorted list
        int[] testValues = {1, 3, 5, 7, 9};
        Node<Integer> list = createTestList(testValues);
        
        System.out.println("Original sorted list:");
        printList(list);
        
        // Add a new number
        int newNumber = 4;
        list = insertSorted(list, newNumber);
        
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);
        
        // Test adding to the beginning of the list
        newNumber = 0;
        list = insertSorted(list, newNumber);
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);
        
        // Test adding to the end of the list
        newNumber = 10;
        list = insertSorted(list, newNumber);
        System.out.println("List after adding number " + newNumber + ":");
        printList(list);
    }
}