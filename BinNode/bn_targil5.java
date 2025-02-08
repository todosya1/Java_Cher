package BinNode;
import unit4.collectionsLib.BinNode;

// Напиши функцию, которая получает binNode int-ов и ссылку на узел в нем.
// Метод должен удалить указанный узел

public class bn_targil5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 2, 1};

        BinNode<Integer> golova = createList(arr);
        printList(createList(arr));
        deleteNode(golova, 2);
        printList(golova);
    }

    public static BinNode<Integer> deleteNode(BinNode<Integer> head, int index) {
        if (head == null) {
            System.out.println("Список не может быть пустым.");
            return null;
        }

        BinNode<Integer> current = head; // создаем указатель
        BinNode<Integer> target = null;  // создаем ноду под удаление
        BinNode<Integer> prev = null;

        int i = 0;
        // поиск нужного узла
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
            return head;
        }

        prev = target.getLeft();
        BinNode<Integer> next = target.getRight();

        // Удаление узла
        if (prev != null) {
            prev.setRight(next); // Устанавливаем новый узел справа от текущего узла
        } else {
            head = next; // Если удаляем голову, обновляем голову
        }

        if (next != null) {
            next.setLeft(prev); // Устанавливаем левый указатель у следующего узла
        }
        return head;
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


}
