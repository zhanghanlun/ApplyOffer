package code._51数组中重复的数字;

public class Duplicate {


    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        }
        boolean duplicate = false;
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                int index = numbers[i];
                if (numbers[i] == numbers[index]) {
                    duplicate = true;
                    duplication[0] = numbers[i];
                    break;
                }else{
                    swap(numbers,i,index);
                }
            }
            if (duplicate) {
                break;
            }
        }
        return duplicate;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,0,2,5,3};
        int[] dup = new int[1];
        System.out.println(new Duplicate().duplicate(nums,7,dup));
        System.out.println(dup[0]);
    }
}
