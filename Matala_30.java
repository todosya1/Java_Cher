import unit4.collectionsLib.Node;

/*
  Функция, которая принимает связный список чисел с плавающей запятой и возвращает true,
   если количество элементов, значение которых выше среднего, равно количеству элементов,
    значение которых ниже среднего. В противном случае функция возвращает false.
*/
public class Matala_30 {
    public static void main(String[] args) {
        Node<Double> list = createList(new double[]{1.5, 2.0, 3.5, 6.0, 7.5, 9.0}); // Пример списка
        System.out.println("Результат: " + isEqualAboveBelowAverage(list));
    }

    public static boolean isEqualAboveBelowAverage(Node<Double> head) {
        if (head == null) return false; // Пустой список

        // Вычисление среднего значения
        double sum = 0;
        int count = 0;
        Node<Double> current = head;

        while (current != null) {
            sum += current.getValue();
            count++;
            current = current.getNext();
        }

        double average = sum / count;

        // Подсчет элементов выше и ниже среднего
        int aboveCount = 0;
        int belowCount = 0;
        current = head;

        while (current != null) {
            if (current.getValue() > average) {
                aboveCount++;
            } else if (current.getValue() < average) {
                belowCount++;
            }
            current = current.getNext();
        }

        // Проверка равенства
        return aboveCount == belowCount;
    }

    public static Node<Double> createList(double[] values) {
        /*
        Вспомогательная функция для создания связного списка из массива
        */
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
}
