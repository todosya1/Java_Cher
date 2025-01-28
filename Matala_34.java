import unit4.collectionsLib.Node;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5


public class Matala_34 {
   public static void main(String[] args) {
        // Test cases for copyList
        Node<String> list = new Node<>("Hello");
        list.setNext(new Node<>("World"));
        list.getNext().setNext(new Node<>("!"));
        
        System.out.println("Original list:");
        printStringList(list);
        
        Node<String> copiedList = copyList(list);
        System.out.println("\nCopied list:");
        printStringList(copiedList);
        
        // Modify original list to prove they are separate
        list.setValue("Changed");
        System.out.println("\nAfter modifying original list:");
        System.out.println("Original list:");
        printStringList(list);
        System.out.println("Copied list (should remain unchanged):");
        printStringList(copiedList);
    }
    
    /**
     * Helper method to print a linked list of strings
     */
    public static void printStringList(Node<String> list) {
        Node<String> current = list;
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
     * Creates a copy of a linked list of strings
     * @param list the original linked list to copy
     * @return a new linked list that is identical to the original
     * Complexity: O(n)
     */
    public static Node<String> copyList(Node<String> list) {
        if (list == null) {
            return null;
        }
        
        Node<String> newList = new Node<String>(list.getValue());
        Node<String> current = newList;
        Node<String> original = list.getNext();
        
        while (original != null) {
            current.setNext(new Node<String>(original.getValue()));
            current = current.getNext();
            original = original.getNext();
        }
        
        return newList;
    }
}  