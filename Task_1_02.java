/* программа выводит список простых чисел от 1 до N */

import java.util.Scanner;
import java.util.ArrayList;

public class Task_1_02 {
    public static void main(String[] args) {
        long startTime, endTime;
        int x = 0;
        ArrayList<Integer> simpleList = new ArrayList<>();
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите число x=: ");
        boolean flag = iScanner.hasNextInt();
        if (flag) {
            x = iScanner.nextInt();
        }
        startTime = System.nanoTime();
        for (int i = 1; i <= x; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple)
                simpleList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println(simpleList);
    }
}
