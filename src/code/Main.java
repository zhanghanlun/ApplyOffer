package code;

import java.util.Scanner;
public class Main {
    //第一题
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] datas = scanner.nextLine().split(" ");
            int m = Integer.parseInt(datas[0]);
            int a1 = Integer.parseInt(datas[1]);
            int h1 = Integer.parseInt(datas[2]);
            int a2 = Integer.parseInt(datas[3]);
            int b2 = Integer.parseInt(datas[4]);
            int h2 = Integer.parseInt(datas[5]);
            int c1 = Integer.parseInt(datas[6]);
            int c2 = Integer.parseInt(datas[7]);
            int c = Integer.parseInt(datas[8]);
            m = m - c;//买投石车
            int attackNum = m / c1;
            int result = 0;
            for (int j = 0; j <= attackNum; j++) {
                int num = (a2 + j) * (int) Math.ceil((double) h2 / (double) ((a1 - b2) - (m - c1 * j) / c2));
                result = Math.max(num, result);
                if (result >= h1) {
                    result = h1;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
