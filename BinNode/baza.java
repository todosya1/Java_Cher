package BinNode;
import unit4.collectionsLib.BinNode;

public class baza {
    /*
    основные методы и приемы для "Bin Node" / "Двунаправленный связный список" / "רשימה מקושרת דו כיוונית"
    1. Конструктор создает новый узел со значением value. Перед ним и за ним нет узлов.
        BinNode<T>(T value)     -->
        BinNode<Integer> singleNode = new BinNode<>(10);

    2.  Конструктор создает новый узел со значением value. За ним находится узел right, перед ним узел left.
        BinNode <T>( BinNode <T>left, T value, BinNode <T> right)  -->
        BinNode<Integer> parentNode = new BinNode<>(leftNode, 10, rightNode); // Создание узла с двумя дочерними узлами

    3.  Метод возвращает значение текущего узла
        T .getValue()            -->
        System.out.println("Создан узел со значением: " + singleNode.getValue());

    4.  Метод .getLeft() возвращает левый дочерний узел типа BinNode<T>
        BinNode<T> .getLeft()

    5.  Метод .getRight() возвращает правый дочерний узел типа BinNode<T>
        BinNode<T> .getRight()
        System.out.println("5. Значение правого дочернего узла: " + parentNode.getRight()); // Вывод: Значение правого дочернего узла: 5

    6.  Метод обновляет значение текущего узла на value
        void setValue(T value)
        parentNode.setValue(333);
        System.out.println("6. Значение измененного родительского узла: " + parentNode.getValue()); // Вывод: Значение родительского узла: 333

    7.  Метод создает/устанавливает ЛЕВЫЙ от текущего узел
        void setLeft(BinNode <T> left)
        BinNode<Integer> newLeftNode = new BinNode<>(20); // Создание нового узла для левого дочернего узла
        parentNode.setLeft(newLeftNode); // Установка нового левого дочернего узла
        System.out.println("7. Значение нового левого дочернего узла: " + parentNode.getLeft().getValue()); // Вывод: Значение нового левого

    8.  Метод создает/устанавливает ПРАВЫЙ от текущего узел
        void setRight(BinNode <T> left)
        BinNode<Integer> newRightNode2 = new BinNode<>(30); // Создание нового узла для правого дочернего узла
        parentNode.setRight(newRightNode2); // Установка нового правого дочернего узла
        System.out.println("8. Значение нового правого дочернего узла: " + parentNode.getRight().getValue()); // Вывод: Значение нового правого дочернего узла: 30

    9.  Метод возвращает ТРУ/ФОЛС если слева есть узел или null
        boolean hasLeft()
        boolean hasLeft = parentNode.hasLeft(); // Проверка наличия левого дочернего узла

    10. Метод возвращает ТРУ/ФОЛС если справа есть узел или null
        boolean hasRight = parentNode.hasRight(); // Проверка наличия правого дочернего узла
        System.out.println("10. Существует ли левый дочерний узел: " + hasRight); // Вывод: Существует ли правый дочерний узел: true
    */

    public static void main(String[] args) {
        // 1. Пример использования первого конструктора  ->  BinNode<T>(T value)
        BinNode<Integer> singleNode = new BinNode<>(10); // Создание узла со значением 10
        System.out.println("1. Создан узел со значением: " + singleNode.getValue());

        // 2. Пример использования второго конструктора  -> BinNode <T>( BinNode <T>left, T value, BinNode <T> right)
        BinNode<Integer> leftNode = new BinNode<>(5); // Создание узла слева
        BinNode<Integer> rightNode = new BinNode<>(15); // Создание узла справа
        BinNode<Integer> parentNode = new BinNode<>(leftNode, 10, rightNode); // Создание узла с двумя дочерними узлами
        System.out.println("2. Создан узел со значением: " + parentNode.getValue() + ", левый узел: " + parentNode.getLeft().getValue() + ", правый узел: " + parentNode.getRight().getValue());

        // 3. Пример использования метода .getValue() для текущего/родительского узла
        System.out.println("3. Значение родительского узла: " + parentNode.getValue()); // Вывод: Значение родительского узла: 10

        // 4. Пример использования метода .getLeft()
        System.out.println("4. Значение левого дочернего узла: " + parentNode.getLeft().getValue()); // Вывод: Значение левого дочернего узла: 5
        // 5. Пример использования метода .getRight()
        System.out.println("5. Значение правого дочернего узла: " + parentNode.getRight().getValue()); // Вывод: Значение правого дочернего узла: 15

        // 6. Метод обновляет значение текущего узла на value
        parentNode.setValue(333);
        System.out.println("6. Значение измененного родительского узла: " + parentNode.getValue()); // Вывод: Значение родительского узла: 10

        // 7. Пример использования метода .setLeft()
        BinNode<Integer> newLeftNode = new BinNode<>(20); // Создание нового узла для левого дочернего узла
        parentNode.setLeft(newLeftNode); // Установка нового левого дочернего узла
        System.out.println("7. Значение нового левого дочернего узла: " + parentNode.getLeft().getValue()); // Вывод: Значение нового левого дочернего узла: 20

        // 8. Пример использования метода .setRight()
        BinNode<Integer> newRightNode2 = new BinNode<>(30); // Создание нового узла для левого дочернего узла
        parentNode.setRight(newRightNode2); // Установка нового левого дочернего узла
        System.out.println("8. Значение нового правого дочернего узла: " + parentNode.getRight().getValue()); // Вывод: Значение нового левого дочернего узла: 30

        // 9. Пример использования метода .hasLeft()
        boolean hasLeft = parentNode.hasLeft(); // Проверка наличия левого дочернего узла
        System.out.println("9. Существует ли левый дочерний узел: " + hasLeft); // Вывод: Существует ли левый дочерний узел: true

        // 10. Пример использования метода .hasRight()
        boolean hasRight = parentNode.hasRight(); // Проверка наличия правого дочернего узла
        System.out.println("10. Существует ли левый дочерний узел: " + hasRight); // Вывод: Существует ли правый дочерний узел: true
    }


/*
    public static BinNode<Integer> createList(int[] values) {
        // создание двусвязного списка из массива.
        BinNode<Integer> head = null;
        BinNode<Integer> current = null;

        for (int i = 0; i < values.length; i++) {
            if (head == null) {
                head = new BinNode<>(values[i]);
                current = head;
            } else {
                current.setNext(new BinNode<>(values[i]));
                current = current.getNext();
            }
        }
        return head;
    }

    public static void printList(BinNode<Integer> head) {
        // пропечатывание списка
        BinNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.getValue());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

 */
}
