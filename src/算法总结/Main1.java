package 算法总结;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int[] array = new int[data.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(data[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < array.length / 2; i++) {
            int count = getStepCount(i, array);
            if (count != -1) {
                min = Math.min(min, count);
            }
        }
        if (min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }

    private static int getStepCount(int n, int[] array) {
        int index = n;
        int count = 1;
        while (index < array.length) {
            if (index == array.length - 1) {
                return count;
            }
            count++;
            index = index + array[index];
        }
        return -1;
    }
}
