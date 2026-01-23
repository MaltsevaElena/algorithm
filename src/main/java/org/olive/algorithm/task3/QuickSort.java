package org.olive.algorithm.task3;

import java.util.Arrays;
import java.util.Stack;

/**
 * QuickSort.
 *
 * @author Elena Maltseva
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {17, 14, 15, 28, 6, 8, -6, 1, 3, 18};
        System.out.println("Unsorted Array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("  Sorted Array: " + Arrays.toString(array));;
    }

    public static void quickSort(int[] arr, int low, int high) {
        //Проверяем надо ли сортировать массив. Нет смысла сортировать пустой массив.
        if (arr == null || arr.length == 0)
            return;

        // Если начальный индекс больше или равен конечному,
        // значит, подмассив состоит из 0 или 1 элемента и уже отсортирован.
        if (low >= high)
            return;

        // Создаем стек для хранения границ подмассивов, которые мы будем сортировать.
        Stack stack = new Stack<>();
        // Помещаем начальные границы всего массива в стек.
        stack.push(low);
        stack.push(high);

        //Основной цикл сортировки. Цикл продолжается, пока в стеке есть элементы.
        while (!stack.isEmpty()) {
            // Извлекаем верхние два элемента из стека.
            // Это границы текущего подмассива, который нужно отсортировать.
            high = (int) stack.pop();
            low = (int) stack.pop();

            // Эта функция берет элемент, перемещает его и размещает остальные элементы так,
            // чтобы все <= pivot были слева, а все > pivot - справа.
            int pivotIndex = partition(arr, low, high);

            //Добавляем новые диапазоны в стек для сортировки.
            // Если pivotIndex - 1 > low, это значит, что в левой части есть хотя бы два элемента и ее нужно сортировать.
            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            // Если pivotIndex + 1 < h, это значит, что в правой части есть хотя бы два элемента и ее нужно сортировать.
            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }


    private static int partition(int[] arr, int low, int high) {
        // Берем последний элемент массива как опорный.
        int pivot = arr[high];
        // i будет указывать на конец той части массива, где находятся элементы,
        // которые меньше или равны опорному.
        int i = low;
        // Итерация по массиву. j проходит по всем элементам кроме опорного.
        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному,
            // тогда этот элемент перемещаем в левую часть массива.
            if (arr[j] <= pivot) {
                // Меняем местами arr[i] и arr[j].
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // Увеличиваем указатель i.
                i++;
            }
        }

        // После цикла все элементы меньше или равны pivot.
        // Позиция i теперь является первой позицией, где элемент больше pivot.
        // Меняем местами опорный элемент arr[high] с элементом arr[i].
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        // Возвращаем индекс опорного элемента.
        return i;
    }

}
