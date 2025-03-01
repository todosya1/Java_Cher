package _3_Recursia;

public class Recursia_ex12 {

    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        System.out.println(findMaxA(testArr, 0));
        System.out.println(findMaxB(testArr, 0, testArr.length - 1));
    }

    /**
     * Рекурсивная функция для поиска максимального значения в массиве.
     * Сравнивает текущий элемент с максимумом оставшейся части массива.
     * @param arr   массив целых чисел
     * @param index текущий проверяемый индекс
     * Сложность по времени: O(n), где n - размер массива
     */
    public static int findMaxA(int[] arr, int index) {
        // Базовый случай: если это последний элемент, возвращаем его
        if (index == arr.length - 1) return arr[index];
        // Рекурсивный шаг: сравниваем текущий элемент с максимумом оставшейся части
        return Math.max(arr[index], findMaxA(arr, index + 1));
    }

    /**
     * Рекурсивная функция для поиска максимального значения в массиве.
     * Делит массив на две половины, находит максимум в каждой половине,
     * и возвращает большее из двух значений.
     * @param arr   массив целых чисел
     * @param left  начальный индекс текущего подмассива
     * @param right конечный индекс текущего подмассива
     * @return максимальный элемент в массиве
     * Сложность по времени: O(n), где n - размер массива
     */
    public static int findMaxB(int[] arr, int left, int right) {
        // Базовый случай: если остался один элемент, возвращаем его
        if (left == right) return arr[left];

        // Находим середину массива
        int mid = (left + right) / 2;

        // Рекурсивный шаг: ищем максимум в левой и правой половинах
        int maxLeft = findMaxB(arr, left, mid);
        int maxRight = findMaxB(arr, mid + 1, right);

        // Возвращаем большее из двух значений
        return Math.max(maxLeft, maxRight);
    }
}