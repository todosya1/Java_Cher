package _3_Recursia;

/* Сложность функции: O(n), так как мы проходим по массиву один раз */
public class Recursia_ex5 {
    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        int size = testArr.length-1;
        printNumbersNegativeNumberPositive(testArr, size);
    }

    /**
     * Рекурсивная функция для поиска чисел, у которых слева отрицательное число, а справа положительное
     * @param arr массив целых чисел
     * @param size длина массива минус 1
     * Сложность по времени: O(n)
     */
    public static void printNumbersNegativeNumberPositive(int[] arr, int size) {
        if (size < 3) return;   // Базовый случай: если в массиве меньше 3 элементов, нечего проверять
        int index = size - 2;   // Вычисляем текущий индекс для проверки

        if (arr[index - 1] < 0 && arr[index + 1] > 0) {
            System.out.println("Число " + arr[index] + " удовлетворяет условию: слева = " + arr[index - 1] + ", справа = " + arr[index + 1]);
        }
        printNumbersNegativeNumberPositive(arr, size - 1);
    }
}