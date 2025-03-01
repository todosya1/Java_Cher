package _3_Recursia;

public class Recursia_ex13 {
    public static void main(String[] args) {
        int[] sortArr = {1, 3, 4, 5, 7, 9, 11, 13, 17, 20};
        int target = 9;
        int size = sortArr.length-1;
        int result = binarySearch(sortArr, target, 0, size);
        System.out.println("Индекс искомого числа " + target + " --> " + result);
    }

    /**
     * Рекурсивная функция для бинарного поиска в отсортированном массиве
     * @param arr    Отсортированный массив
     * @param target Искомое число
     * @param left   Левая граница диапазона поиска
     * @param right  Правая граница диапазона поиска
     * @return Индекс искомого числа, если найдено, или -1, если не найдено
     * Сложность: O(log n), где n - размер массива
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        // Базовый случай: если диапазон недействителен, возвращаем -1
        if (left > right) return -1;
        // Вычисляем средний индекс
        int mid = left + (right - left) / 2;
        // Проверяем, является ли средний элемент искомым
        if (arr[mid] == target) return mid;

        // Рекурсивный шаг: ищем в левой или правой половине
        if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid-1); // Ищем в левой половине
        } else {
            return binarySearch(arr, target, mid+1, right); // Ищем в правой половине
        }
    }
}