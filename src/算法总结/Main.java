package 算法总结;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int base = n + m - 1;
        int up = n - 1;
        int result = getResult(base,up);
        System.out.println(result);
    }

    private static int getResult(int base, int up) {
        double result = 1.0;
        int count = base - up + 1;
        for (int i = up; i >= 1; i--) {
            if (base <= count){
                result = result/up;
            }else{
                result = result * base / up;
                base--;
            }
            if (result>1000000007){
                result = result%1000000007;
            }
        }
        if (base>=count){
            for (int i = count;i<=base;i++){
                result = result*i%1000000007;
            }
        }
        return (int)result;
    }
}
