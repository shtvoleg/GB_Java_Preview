/* Реализовать алгоритм пирамидальной сортировки (сортировка кучей). Обучающийся: Шитов О.В., "Разработчик 4544", будни, утро, до 19:00 мск 6.06.2023 */

public class Task_2_01 {
    public static void myHeap(int[] array, int n) {

        for (int i = (n / 2 - 1); i >= 0; i--) // построение пирамиды (кучи)
            subHeap(array, n, i);

        for (int i = n - 1; i >= 0; i--) { // извлекаем элементы из кучи
            int tmp = array[0]; // перемещаем текущий корень в конец списка
            array[0] = array[i];
            array[i] = tmp;
            subHeap(array, i, 0); // вызываем процедуру subHeap на уменьшенной подкуче
        }
    }

    public static void subHeap(int[] array, int n, int i) {
        int biggest = i; // это корень
        int leftChild = 2 * i + 1; // это левый потомок
        int rightChild = 2 * i + 2; // это правый потомок

        if (leftChild < n && array[leftChild] > array[biggest]) // если левый потомок больше предка
            biggest = leftChild;

        if (rightChild < n && array[rightChild] > array[biggest]) // если правый потомок больше текущего максимального
            biggest = rightChild;

        if (biggest != i) { // если максимальный элемент не является вершиной
            int tmp = array[i];
            array[i] = array[biggest];
            array[biggest] = tmp;
            subHeap(array, n, biggest); // рекурсия по подкуче
        }
    }

    public static void myPrint(String head, int[] array, int n) { // вывод массива в консоль под шапкой
        System.out.println(head);
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
    }

    public static void main(String[] args) {
        int[] array = { 5, 7, 9, 4, 3, 8, 2, 1, 0, 6 };
        int n = array.length;

        myPrint("\nИсходный массив:", array, n); // вывод исходного массива в консоль
        myHeap(array, n); // построение пирамиды (кучи)
        myPrint("\nРезультат:", array, n); // вывод результата в консоль
    }
}