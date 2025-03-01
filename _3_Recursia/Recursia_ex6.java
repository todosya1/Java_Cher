package _3_Recursia;

/* Сложность функции: O(n), так как мы проходим по массиву один раз */
public class Recursia_ex6 {
    public static void main(String[] args) {
        int[] testArr = {1, -5, 10, -2, 4, 6, -7, 8, -9, 3};
        int size = testArr.length-1;
        int param_1 = 4, param_2 = 6;
        System.out.println(checkAdjacent(testArr, size, param_1, param_2));
    }

    /**
     * Рекурсивная функция для проверки, являются ли два числа соседними в массиве
     * Порядок чисел не имеет значения
     * @param arr массив целых чисел
     * @param size текущий проверяемый индекс
     * @param param_1 первое искомое число
     * @param param_2 второе искомое число
     * @return true если числа являются соседними, иначе false
     * Сложность по времени: O(n), где n - размер массива
     */
    public static boolean checkAdjacent(int[] arr, int size, int param_1, int param_2) {
        if (size <= 0) return false; // Базовый случай: дошли до начала массива, соседние числа не найдены
        // Проверяем, совпадает ли текущая пара чисел с искомыми (в любом порядке)
        if ((arr[size] == param_1 && arr[size-1] == param_2) ||
                (arr[size] == param_2 && arr[size-1] == param_1)) {
            return true;
        }
        // Рекурсивный вызов для проверки следующей пары
        return checkAdjacent(arr, size-1, param_1, param_2);
    }
}