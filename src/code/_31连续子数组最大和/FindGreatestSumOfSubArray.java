package code._31连续子数组最大和;


import java.util.Map;

/**
 * 输入一个整形数组，数组里有正数和负数。数组中一个或连续的多个整数
 * 组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int[] f = new int[array.length];
        f[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (f[i - 1] < 0) {
                f[i] = array[i];
            } else {
                f[i] = f[i - 1] + array[i];
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args){
        int[] array={6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }
}
