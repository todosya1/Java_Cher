package BinNode;

import unit4.collectionsLib.BinNode;

//Напиши функцию, которая получает int n и возвращает binNode последовательных целых чисел

public class bn_targil1 {
    public static void main(String[] args) {
      createOkevList(5);
      printList(createOkevList(5));
    }

    public static BinNode<Integer> createOkevList(int n) {
        // Создание двусвязного списка последовательных целых чисел от 1 до n.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 1; i <= n; i++) {
            BinNode<Integer> newNode = new BinNode<>(i); // Создание нового узла
            if (head == null) {
                head = newNode; // Если это первый узел, он становится головой
                current = head;
            } else {
                current.setRight(newNode); // Установка следующего узла
                newNode.setLeft(current); // Установка предыдущего узла
                current = newNode; // Переход к новому узлу
            }
        }
        return head; // Возвращаем голову списка
    }

    public static void printList(BinNode<Integer> head) {
        // пропечатывание списка
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getRight() != null) { // Проверяем наличие правого узла
                System.out.print(" <-> ");
            }
            current = current.getRight(); // Переход к следующему узлу
        }
        System.out.println(); // Печатаем новую строку после списка
    }
}
