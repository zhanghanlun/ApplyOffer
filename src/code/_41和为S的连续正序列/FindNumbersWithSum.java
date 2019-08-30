package code._41和为S的连续正序列;

import java.util.ArrayList;

public class FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return result;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int tempSum = array[start] + array[end];
            if (tempSum == sum) {
                result.add(array[start]);
                result.add(array[end]);
                break;
            } else if (tempSum > sum) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] array = {1,2,4,7,11,15};
        System.out.println(new FindNumbersWithSum().FindNumbersWithSum(array,15));
    }
}
