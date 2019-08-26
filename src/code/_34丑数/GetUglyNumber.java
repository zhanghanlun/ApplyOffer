package code._34丑数;

public class GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] nums = new int[index];
        nums[0] = 1;
        int next = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (next < index) {
            int min = Math.min(Math.min(nums[index2] * 2, nums[index3] * 3), nums[index5] * 5);
            nums[next] = min;
            while (nums[index2] * 2 <= min) {
                index2++;
            }
            while (nums[index3] * 3 <= min) {
                index3++;
            }
            while (nums[index5] * 5 <= min) {
                index5++;
            }
            next++;
        }
        return nums[index-1];
    }

    public static void main(String[] args){
        int index = 2;
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(index));
    }
}
