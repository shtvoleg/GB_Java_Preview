/*  программа запрашивает натуральное число, проверяет его и подсчитывает сумму от 1 до данного числа включительно. */

import java.util.Scanner;

public class Task_1_01 {
    public static void main(String[] args) {
        long startTime, endTime;
        int sum;
        int x = 0;
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число x=: ");
        boolean flag = iScanner.hasNextInt();
        if (flag) {
            x = iScanner.nextInt();
        }
        startTime = System.nanoTime();
        sum = (1 + x) * x / 2;
        endTime = System.nanoTime();
        System.out.printf("Сумма чисел от 1 до x (включительно), равна %s. Время равно %d.", sum,
                (endTime - startTime));

        /* то же, через цикл */
        startTime = System.nanoTime();
        for (int i = 1; i <= x; i++)
            sum += i;
        endTime = System.nanoTime();
        System.out.printf("\nСумма чисел от 1 до x (включительно), равна %s. Время равно %d.", sum,
                (endTime - startTime));
        iScanner.close();
    }
}