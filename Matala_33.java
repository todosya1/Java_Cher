import unit4.collectionsLib.Node;

public class Matala_33 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 3.5, 6.7, 1.2, 4.0}); // Пример списка
        System.out.println("Исходный список:");
        printList(list);

        Node<Double> uniqueList = removeDuplicates(list);
        System.out.println("Список без дубликатов:");
        printList(uniqueList);
    }

    public static Node<Double> removeDuplicates(Node<Double> head) {
        if (head == null) {
            return null; // Пустой список
        }

        Node<Double> current = head;

        while (current != null) {
            Node<Double> runner = current; // Для проверки всех следующих элементов
            while (runner.getNext() != null) {
                if (runner.getNext().getValue().equals(current.getValue())) {
                    // Удаляем дубликат
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }

        return head; // Возвращаем список без дубликатов
    }

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

    public static void printList(Node<Double> head) {
        Node<Double> current = head;

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
