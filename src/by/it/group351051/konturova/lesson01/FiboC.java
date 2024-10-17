package by.it.group351051.konturova.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 10;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        long pisanoPeriod = getPisanoPeriod(m);

        long remainder = n % pisanoPeriod;

        return getFibonacciMod(remainder, m);
    }

    private long getPisanoPeriod(int m) {
        long prev = 0;
        long curr = 1;
        long period = 0;

        for (int i = 0; i < m * m; i++) {
            long temp = curr;
            curr = (prev + curr) % m;
            prev = temp;

            // Период начинается с 0, 1
            if (prev == 0 && curr == 1) {
                period = i + 1;
                break;
            }
        }

        return period;
    }

    private long getFibonacciMod(long n, int m) {
        long prev = 0;
        long curr = 1;

        if (n == 0) return 0;
        if (n == 1) return 1;

        for (long i = 2; i <= n; i++) {
            long temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
        }

        return curr;
    }


}

