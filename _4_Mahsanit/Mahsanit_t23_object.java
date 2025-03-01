package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_t23_object {
    public static void main(String[] args) {
        Stack<Integer> st = new <Integer>Stack();

        // Входные данные: число и стек цифр
        int num = 2507;
        st.push(5);
        st.push(0);
        st.push(5);
        st.push(2);
        st.push(7);

        System.out.println("Исходный стек: " + st);
        System.out.println("Содержит ли стек все цифры числа? " + checkNumberStack(st, num));
    }

    /**
     * Функция: checkNumberStack
     * Описание: Проверяет, присутствуют ли цифры заданного числа в стеке в любом порядке.
     *          Исходный стек остается неизменным.
     *
     * @param st  Стек целых чисел, представляющих цифры
     * @param num Положительное целое число, цифры которого нужно проверить в стеке
     * @return true если все цифры числа присутствуют последовательно в любом порядке, иначе false
     *
     * Временная сложность: O(n * d), где:
     * n - размер стека
     * d - количество цифр в числе
     */
    public static boolean checkNumberStack(Stack<Integer> st, int num) {
        Stack<Integer> temp = new <Integer>Stack(); // Временный стек для восстановления исходного
        int size = 0;
        int tempNum = num;

        // Подсчитываем количество цифр во входном числе
        while (tempNum != 0) {
            tempNum /= 10;
            size++;
        }

        // Создаем массив для хранения цифр числа
        int[] arrayNumbers = new int[size];

        // Разбиваем число на цифры и сохраняем их в массив
        for (int i = 0; num != 0; i++) {
            arrayNumbers[i] = num % 10;
            num /= 10;
        }

        // Проходим по стеку и проверяем совпадения цифр
        while (!st.isEmpty()) {
            int current = st.pop();  // Получаем верхний элемент стека
            temp.push(current);      // Сохраняем его во временный стек
            boolean flag = false;

            // Проверяем, совпадает ли текущий элемент с какой-либо цифрой в массиве
            for (int i = 0; i < size; i++) {
                if (arrayNumbers[i] == current) {
                    flag = true;
                    break; // Выходим из цикла, как только найдено совпадение
                }
            }

            // Если совпадение не найдено, восстанавливаем стек и возвращаем false
            if (!flag) {
                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }
                return false;
            }
        }

        // Восстанавливаем исходный стек
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        return true; // Все цифры числа найдены в стеке
    }
}