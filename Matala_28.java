import unit4.collectionsLib.Node;

public class Matala_28 {
    /*
    Функция, которая принимает связный список целых чисел и возвращает сумму элементов списка.
    */
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{5, 5, 15, 5, 5, 25}); // Пример списка
        System.out.println("Сумма элементов списка: " + sumOfList(list));
        printList(list);
    }

    public static int sumOfList(Node<Integer> head) {
        int sum = 0;
        Node<Integer> current = head;

        while (current != null) {
            sum += current.getValue(); // Добавляем значение текущего узла
            current = current.getNext(); // Переходим к следующему узлу
        }

        return sum; // Возвращаем сумму
    }

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
