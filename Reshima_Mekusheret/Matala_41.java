package Reshima_Mekusheret;

import unit4.collectionsLib.Node;


/**
 * Напишите функцию, которая принимает связный список целых чисел.
 * Функция должна обновить список так, чтобы все элементы, больше 100,
 * находились в начале списка, а все числа, меньше или равные 100,
 * находились в конце списка.
 */
public class Matala_41 {

    public static void main(String[] args) {
        // Тестовые случаи
        int[] arr = {1, 2, 50, 200, 75, 25, 300, 100};
        Node<Integer> list1 = createList(arr);
        printList(list1);
        rearrangeList(list1);
        System.out.println("После сортировки:");
        printList(list1);
    }

    /**
     * Перемещает все элементы, больше 100, в начало списка
     * Сложность: O(n),
     * @param head начало списка
     */
    public static void rearrangeList(Node<Integer> head) {
        if (head == null || head.getNext() == null) return; // пустой список или список с одним элементом
            
        Node<Integer> dummyLess = new Node<>(0);    // dummy-узел для чисел <= 100
        Node<Integer> dummyMore = new Node<>(0);    // dummy-узел для чисел > 100
        Node<Integer> less = dummyLess;             // указатель для чисел <= 100
        Node<Integer> more = dummyMore;             // указатель для чисел > 100
        Node<Integer> current = head;               // указатель на текущий узел

        // Создание двух новых списков
        while (current != null) {
            if (current.getValue() > 100) {
                more.setNext(new Node<>(current.getValue()));
                more = more.getNext();
            } else {
                less.setNext(new Node<>(current.getValue()));
                less = less.getNext();
            }
            current = current.getNext();
        }

        // Соединение списков
        more.setNext(dummyLess.getNext());

        // Если есть элементы, большие 100
        if (dummyMore.getNext() != null) {
            // Копирование значений в исходный список
            current = head;
            Node<Integer> source = dummyMore.getNext();
            while (source != null) {
                current.setValue(source.getValue());
                current = current.getNext();
                source = source.getNext();
            }
        }
    }

    /**
     * Вспомогательный метод для создания связного списка из массива
     */
    public static Node<Integer> createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<>(arr[0]);
        Node<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.setNext(new Node<>(arr[i]));
            current = current.getNext();
        }

        return head;
    }

    /**
     * Вспомогательный метод для печати списка
     */
    public static void printList(Node<Integer> head) {
        if (head == null) {
            System.out.println("Пустой список");
            return;
        }

        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}