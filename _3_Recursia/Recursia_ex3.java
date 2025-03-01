package _3_Recursia;

/* Сложность функции (hasNeighborSumIsTen): O(n), так как мы проходим по массиву один раз */
public class Recursia_ex3 {
    public static void main(String[] args) {
        int[] testArr = {3, 4, 2, 8, 2, 4, 5, 6, 7, 8, -1, 0, -19};
        int size = testArr.length-1;
        System.out.println(hasNeighborSumIsTen(testArr, size));
    }

    /**
     * Рекурсивная функция для поиска двух соседних чисел, сумма которых делится на 10
     * @param arr массив целых чисел
     * @param index длина массива минус 1
     * @return true если найдены два соседних числа с суммой кратной 10, иначе false
     * Сложность по времени: O(n)
     */
    public static boolean hasNeighborSumIsTen(int[] arr, int index) {
        if (index <= 0) return false; // Базовый случай: дошли до начала массива
        int sum = arr[index] + arr[index - 1];
        if (sum != 0 && sum % 10 == 0) return true; // Проверяем что сумма не 0 и делится на 10
        return hasNeighborSumIsTen(arr, index - 1);
    }
}