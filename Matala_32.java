import unit4.collectionsLib.Node;
// Напиши функцию, которая проверяет наличие числа (таргет0 в решиме мекушерет
public class Matala_32 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.2, 3.5, 4.0, 6.7}); // Пример списка
        double number = 4.0; // Число для поиска
        System.out.println("Число " + number + " найдено в списке: " + containsNumber(list, number));

        number = 5.5;
        System.out.println("Число " + number + " найдено в списке: " + containsNumber(list, number));
    }

    public static boolean containsNumber(Node<Double> head, double target) {
        Node<Double> current = head;

        while (current != null) {
            if (current.getValue() == target) {
                return true; // Число найдено
            }
            current = current.getNext();
        }

        return false; // Число не найдено
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
