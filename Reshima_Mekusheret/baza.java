package Reshima_Mekusheret;

import unit4.collectionsLib.Node;

public class baza {
    /*

    основные методы и приемы для "Linked list" / "Связный список" / "רשימה מקושרת"
    -- current.getValue() -     получить значение текущей ноды
    -- current.getNext()  -     получить значение следующей ноды
    -- current.setNext(new Node<>(value)) - установить значение следующей ноды
    -- current = current.getNext();   -- Переходим к следующему узлу

    1 - создание списка из array:   public static Node<Integer> createList(int[] values) { return head }
    2 - пропечатывание списка:      public static void printList(Node<Integer> head){}


    */

    public static void main(String[] args) {
        Node<Integer> list = createList(new int[]{5, 5, 15, 5, 5, 25}); // Пример списка


        printList(list);
    }


    public static Node<Integer> createList(int[] values) {
        // создание списка из arr.
        Node<Integer> head = null;
        Node<Integer> current = null;

        for(int i = 0; i < values.length; i++) {
            if (head == null) {
                head = new Node<>(values[i]);
                current = head;
            } else {
                current.setNext(new Node<>(values[i]));
                current = current.getNext();
            }
        }
        return head;
    }

    public static void printList(Node<Integer> head) {
        // пропечатывание списка
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
