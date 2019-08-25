package code._29数组中出现次数超过一半的数字;

public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (result == array[i]) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        if (check(array, result)) {
            return result;
        } else {
            return 0;
        }

    }

    private boolean check(int[] array, int result) {
        int length = array.length;
        int count = 0;
        for (int num : array) {
            if (num == result) {
                count++;
            }
        }
        return count > length / 2;
    }

    public static void main(String[] args){
        int[] array={1,1,2,2,3,4,5};
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(array));
    }
}
