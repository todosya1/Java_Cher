package _5_Queue;
import unit4.collectionsLib.Stack;
import unit4.collectionsLib.Queue;

public class baza_queue {
    /*
    основные методы и приемы для "TOR" / "FIFO" / "QUEUE"
    Пример создания очереди:
    Queue<Integer> qu = new Queue<Integer>();
    --  void qu.insert() - положить в конец очереди значение
    --  qu.remove()      - удалить и "дать пользователю"/вернуть значение с вершины тора
    --  qu.head()        - посмотреть значение на вершине стека (без удаления)
    --  qu.isEmpty()     - вернет TRUE если тор пустой. Boolean
    --  qu.toString()    - пропечатает махсанит.
        System.out.println(q.toString());
    Пример создания тора:
    Queue<Integer> q = new Queue<Integer>();
    Queue<String> t = new Queue<String>();
    */

    public static int findMax(Queue<Integer> queue) {
        // Проверка на null
        if (queue == null) {
            System.out.println("Ошибка: очередь не инициализирована");
            return 0;
        }
        // Проверка на пустоту
        if (queue.isEmpty()) {
            System.out.println("Ошибка: очередь пуста");
            return 0;
        }
    
        Queue<Integer> tempQueue = new Queue<Integer>();
        int max = queue.head(); // Первый элемент тора как начальный максимум
    
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current > max) {
                max = current;
            }
            tempQueue.insert(current);
        }
    }
    public static void main(String[] args) {
        // Пример 1: Работа с числами
        Queue<Integer> q = new Queue<Integer>();
        q.insert(10);
        q.insert(20);
        q.insert(30);
        System.out.println("Вершина тора: " + q.head()); // выведет 10

        System.out.println(q.toString());

        // Пример 2: Посмотреть содержимое
        // Но после этого действия было бы неплохо их запилить обратно.
        System.out.println("Содержимое очереди:");
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        } //  выведет [10,20,30]

        // Пример 3: Работа со строками
        Queue<String> words = new Queue<String>();
        words.insert("Привет");
        words.insert("Мир");
        words.insert("!");
        System.out.println(words);

        // Пример 4: Копирование очереди
        Queue<String> copyQueue = new Queue<String>();
        Queue<String> tempQueue = new Queue<String>();

        // Сначала перекладываем во временную очередь
        while (!words.isEmpty()) {
            String value = words.remove();
            tempQueue.insert(value);
        }

        // Теперь из временной очереди в обе очереди
        while (!tempQueue.isEmpty()) {
            String value = tempQueue.remove();
            words.insert(value);
            copyQueue.insert(value);
        }

        // Пример 5: Подсчет элементов в очереди
        int count = 0;
        Queue<String> tempCount = new Queue<String>();
        while (!words.isEmpty()) {
            tempCount.insert(words.remove());
            count++;
        }
        // Возвращаем элементы обратно
        while (!tempCount.isEmpty()) {
            words.insert(tempCount.remove());
        }
        System.out.println("Количество элементов: " + count);

        // Пример 6: Поиск максимального элемента
        Queue<Integer> numbers2 = new Queue<Integer>();
        numbers2.insert(5);
        numbers2.insert(8);
        numbers2.insert(3);
        numbers2.insert(12);
        numbers2.insert(9);

        int max = findMax(numbers2);
        System.out.println("Максимальный элемент: " + max);
    }
}