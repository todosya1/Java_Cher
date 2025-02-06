package BinNode;

import unit4.collectionsLib.BinNode;

// Напиши функцию, которая получает binNode int-ов, ссылку на узел в нем и целое число num.
// Метод должен добавить новый элемент со значением num слева от полученного узла

public class bn_targil4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};

        BinNode<Integer> golova = createList(arr);
        printList(createList(arr));
        insertNumList(golova, 3, 777);
        printList(golova);
    }

    public static void insertNumList(BinNode<Integer> head, int index, int num) {
        if (head == null) {
            System.out.println("Список не может быть пустым.");
            return;
        }
        index--;
        BinNode<Integer> current = head;
        BinNode<Integer> target = null;
        int i = 0;
        while (current != null) {
            if (i == index) {
                target = current;
                break;
            }
            current = current.getRight();
            i++;
        }

        if (target == null) {
            System.out.println("Индекс вне диапазона.");
            return;
        }

        // Создаем новый узел с заданным значением
        BinNode<Integer> newNode = new BinNode<>(num);

        // Устанавливаем связи для нового узла
        newNode.setLeft(target); // Устанавливаем левый указатель
        newNode.setRight(target.getRight()); // Устанавливаем правый указатель

        if (target.getRight() != null) {
            target.getRight().setLeft(newNode); // Устанавливаем левый указатель у следующего узла
        }

        target.setRight(newNode); // Устанавливаем новый узел справа от текущего узла
    }


    public static BinNode<Integer> createList(int[] values) {
        // создание двусвязного списка из массива.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int bafer : values) {
            BinNode<Integer> newBinNode = new BinNode<>(bafer); // Создание нового узла
            if (head == null) {
                head = newBinNode; // Если это первый узел, он становится головой
                current = head;
            } else {
                current.setRight(newBinNode); // Установка следующего узла
                newBinNode.setLeft(current);  // Установка предыдущего узла ("парное связывание")
                current = newBinNode; // Переход к новому узлу
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
