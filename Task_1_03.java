/* Пишем алгоритм Фибоначчи линейно */

public class Task_1_03 {
    public static int main(int number, AtomicLong cnt) {
        if (number <= 2)
            return 1;
        int f1 = 1, f2 = 1;
        int f3 = f1 + f2;
        while (number-- > 3) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            cnt.incrementAndGet();
        }
        return f3;
    }
}

/*
 * Пишем алгоритм Фибоначчи рекурсивно
 * public static int fib(int number, AtomicLong cnt) {
 * cnt.incrementAndGet();
 * if (number <= 2) return 1;
 * return fib(number - 1, cnt) + fib(number - 2, cnt);
 * }
 */
