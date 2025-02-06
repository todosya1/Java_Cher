package BinNode;

import unit4.collectionsLib.BinNode;

// Напиши функцию, которая получает binNode int-ов и печатает их слева направо
// вторая функция с права налево

public class bn_targil2 {
    public static void main(String[] args) {
      createOkevList(5);
      printList(createOkevList(5));
      printRightList(createOkevList(5));
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

    public static void printRightList(BinNode<Integer> head) {

        // Найдем конец списка
        BinNode<Integer> current = head;        // создаем указатель
        while (current.getRight() != null) {    // Ищем последний узел
            current = current.getRight();
        }

        // Печатаем значения в обратном порядке
        while (current != null) { // Печатаем от конца к началу
            System.out.print(current.getValue());
            if (current.getLeft() != null) { // Проверяем наличие левого узла
                System.out.print(" <-> ");
            }
            current = current.getLeft();
        }
        System.out.println(); // Печатаем новую строку после списка
    }
}
