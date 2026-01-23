package org.olive.algorithm.task2;

/**
 * Task2.
 *
 * @author Elena Maltseva
 */
public class Task2 {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9, 11, 13};

        String dataToString = "[1, 3, 5, 7, 9, 11, 13]";

        int resultStart = binarySearch(data, 1);
        System.out.println("binarySearch(" + dataToString + ", 1)-> ожидаем 0(элемент в начале массива). Результат индекс: " + resultStart);

        int resultEnd = binarySearch(data, 13);
        System.out.println("binarySearch(" + dataToString + ", 13)-> ожидаем 6(элемент в конце массива). Результат индекс: " + resultEnd);

        int resultNotFound = binarySearch(data, 6);
        System.out.println("binarySearch(" + dataToString + ", 6)-> ожидаем -1(такого элемента нет в массиве). Результат индекс: " + resultNotFound);


        /*
        7. Почему бинарный поиск нельзя применять к неотсортированному массиву?
        Потому что на каждом шаге мы сравниваем искомое число со средним элементом.
        Если массив отсортирован, мы точно знаем, в какой половине может находиться число.
        В неотсортированном массиве алгоритм не будет работать правильно.

        8. Какая асимптотическая сложность по времени и почему это O(log n)?
        Временная сложность — O(log n), потому что на каждой итерации цикла область поиска сокращается ровно в два раза.
        Вопрос в том, сколько раз нужно разделить число n на 2.
        Математически количество таких делений выражается уравнением 2^k = n, откуда k = log n.
        Поэтому количество операций растет логарифмически относительно размера входных данных.

        9. Какая сложность по памяти?
        Сложность по памяти — O(1) (константная).
        Мы используем фиксированное количество дополнительных переменных (left, right, mid),
        не создаем копий массива и не используем рекурсию.
         */
    }
}
