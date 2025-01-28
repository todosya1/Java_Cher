import unit4.collectionsLib.Node;

// מגישים:
// יבגני נמצ'נקו 321404634
// שמיאקין לאוניד 336540331
// כיתה 48-5

/**
 * this class contains functions for removing duplicates characters from reshima mekusheret
 */
public class Matala_40 {
    public static void main(String[] args) {
        // Тестовые случаи
        String[] tests = {
                "kkkbkzeez",   // Должно стать "kbkzez"
                "aaaa",
               };

        for (int i = 0; i < tests.length; i++) {
            Node<Character> list = createList(tests[i]);
            System.out.println("original reshima: " + tests[i]);
            System.out.print("Измененный список: ");
            printList(removeConsecutiveDuplicates(list));
            System.out.println();
        }
    }
    /**
     * Удаляет последовательные дубликаты символов из связанного списка.
     * Сохраняет первый символ в каждой последовательности и удаляет остальные.
     * Сохраняет порядок символов.
     * Сложность времени: O(n)
     * @param head голова списка символов
     * @return голова измененного списка
     */
    public static Node<Character> removeConsecutiveDuplicates(Node<Character> head) {
        // Если список пуст или имеет только один узел
        if (head == null || head.getNext() == null) {
            return head;
        }
        
        Node<Character> current = head;
        
        // Обход списка
        while (current != null && current.getNext() != null) {
            // Если текущий символ равен следующему
            if (current.getValue().equals(current.getNext().getValue())) {
                // Пропустить следующий узел
                current.setNext(current.getNext().getNext());
            } else {
                // Перейти к следующему узлу только если не найден дубликат
                current = current.getNext();
            }
        }
        
        return head;
    }
    
    /**
     * Вспомогательный метод для создания связанного списка символов из строки
     */
    public static Node<Character> createList(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        
        Node<Character> head = new Node<>(str.charAt(0));
        Node<Character> current = head;
        
        for (int i = 1; i < str.length(); i++) {
            current.setNext(new Node<>(str.charAt(i)));
            current = current.getNext();
        }
        
        return head;
    }
    
    /**
     * Вспомогательный метод для печати списка символов
     */
    public static void printList(Node<Character> head) {
        Node<Character> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            current = current.getNext();
        }
        System.out.println();
    }
    

}