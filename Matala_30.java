import unit4.collectionsLib.Node;

/*
  Функция на Java, которая проверяет,
  упорядочены ли элементы связного списка в порядке возрастания:
*/
public class Matala_30 {
    public static void main(String[] args) {
        Node<Integer> list1 = createList(new int[]{1, 2, 3, 4, 5}); // Упорядоченный список
        Node<Integer> list2 = createList(new int[]{1, 3, 0, 4, 5}); // Неупорядоченный список

        System.out.println("Список 1 упорядочен по возрастанию: " + isAscending(list1));
        System.out.println("Список 2 упорядочен по возрастанию: " + isAscending(list2));
    }

    public static boolean isAscending(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true; // Пустой список или список с одним элементом считается упорядоченным
        }

        Node<Integer> current = head;

        while (current.getNext() != null) {
            if (current.getValue() > current.getNext().getValue()) {
                return false; // Найдено нарушение порядка возрастания
            }
            current = current.getNext();
        }

        return true; // Все элементы упорядочены по возрастанию
    }

    public static Node<Integer> createList(int[] values) {
        /*
        Вспомогательная функция для создания связного списка из массива
        */
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
