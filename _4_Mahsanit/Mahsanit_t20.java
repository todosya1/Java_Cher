package _4_Mahsanit;

import unit4.collectionsLib.Stack;

public class Mahsanit_t20 {

    public static double whatIsTheLargestDouble(Stack<Double> st) {
        /*
         * Функция ищет наибольшее вещественное число в стеке и удаляет его
         * Вход: Стек вещественных чисел
         * Выход: Наибольшее вещественное число
         *
         * Временная сложность: O(n), где n - количество элементов в стеке
         * - Первый цикл (поиск максимума): O(n)
         * - Второй цикл (восстановление стека): O(n)
         * Итого: O(n) + O(n) = O(2n) = O(n)
         */
        Stack<Double> temp = new <Double>Stack();
        double max = st.top();  // Берём первый элемент как начальный максимум
        double current;

        // Ищем максимум и сохраняем элементы во временный стек
        while (!st.isEmpty()) {
            current = st.pop();
            if (current > max) {
                max = current;
            }
            temp.push(current);
        }

        // Восстанавливаем стек без максимального элемента
        while (!temp.isEmpty())
            if(temp.top() != max)
                st.push(temp.pop());
            else
                temp.pop();

        return max;
    }

    public static void main(String[] args) {
        Stack<Double> st = new <Double>Stack();
        st.push(1.125);
        st.push(1.25);
        st.push(1.5001);
        st.push(1.5);
        st.push(1.0001);


        System.out.println(st);
        System.out.println(whatIsTheLargestDouble(st));
        System.out.println(st);

    }


}