package code._9斐波那契数列;

public class Fibonacci {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
