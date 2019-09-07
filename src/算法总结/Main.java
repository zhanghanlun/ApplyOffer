package 算法总结;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int base = n + m - 1;
        int up = n - 1;
        int result = (int) (getCount1(m + 1, base) / getCount(up)) % 1000000007;
        System.out.println(result);
    }

    public static double getCount(int n) {
        double count = 1;
        for (int i = 1; i <= n; i++) {
            count = count * i;
        }
        return count;
    }

    public static double getCount1(int start, int end) {
        double count = start;
        for (int i = start + 1; i <= end; i++) {
            count = count * i;
        }
        return count;
    }
}
