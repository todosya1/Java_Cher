import unit4.collectionsLib.Node;

public class Matala_32 {
    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{2, 7, 5, 3, 2, 2, 1, 1, 2, 2}); // Пример списка
        printList(list);
        int number = 2; // Число, которое нужно найти
        System.out.println("Количество последовательностей числа " + number + ": " + countSequences(list, number));
    }

    public static int countSequences(Node<Integer> head, int target) {
        if (head == null) {
            return 0; // Пустой список
        }

        int count = 0;
        boolean inSequence = false; // Флаг для отслеживания текущей последовательности
        Node<Integer> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                if (!inSequence) {
                    count++; // Новая последовательность
                    inSequence = true;
                }
            } else {
                inSequence = false; // Конец текущей последовательности
            }
            current = current.getNext();
        }

        return count;
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
