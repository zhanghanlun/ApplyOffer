package code._65滑动窗口的最大值;

import java.util.ArrayList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size > num.length || size == 0) {
            return result;
        }

        int length = num.length;
        int max = getMax(num, 0, size - 1);
        result.add(max);
        for (int i = 1; i <= length - size; i++) {
            if (max <= num[i + size - 1]) {
                max = num[i + size - 1];
                result.add(max);
                continue;
            }
            max = getMax(num, i, i + size - 1);
            result.add(max);
        }
        return result;
    }

    private int getMax(int[] num, int start, int end) {
        int max = num[start];
        for (int i = start + 1; i <= end; i++) {
            max = Math.max(max, num[i]);
        }
        return max;
    }


    public static void main(String[] args){
        int[] array = {2,3,4,2,6,2,5,1};
        System.out.println(new MaxInWindows().maxInWindows(array,3));
    }
}
