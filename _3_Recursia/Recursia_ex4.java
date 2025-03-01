package _3_Recursia;

/* Сложность функции (sumOfTheTenDividedNums): O(n), так как мы проходим по массиву один раз */
public class Recursia_ex4 {
    public static void main(String[] args) {
        int[] testArr = {30, 4, 2, 30, 2, 40, 5, 6, 7, 8, -1, 0, -19};
        int size = testArr.length-1;
        System.out.println(sumOfTheTenDividedNums(testArr, size));
    }

    /**
     * Рекурсивная функция для подсчёта суммы чисел, делящихся на 10
     * @param arr массив целых чисел
     * @param index длина массива минус 1
     * @return сумма всех чисел, которые делятся на 10
     * Сложность по времени: O(n)
     */
    public static int sumOfTheTenDividedNums(int[] arr, int index) {
        if (index < 0) return 0; // Базовый случай: дошли до начала массива
        if (arr[index] % 10 == 0) {
            return arr[index] + sumOfTheTenDividedNums(arr, index - 1);
        } else {
            return sumOfTheTenDividedNums(arr, index - 1);
        }
    }
}