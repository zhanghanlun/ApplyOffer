package code._8旋转数组的最小数字;

public class MinNumInRotatingArray {
    public int minNumberInRotateArray(int[] array) {
        if (array[0] < array[array.length - 1] || array.length == 1) {
            return array[0];
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (array[start] >= array[end]) {
            if (start + 1 == end){
                mid = end;
                break;
            }
            mid = (start + end)/2;
            if (array[mid] == array[start]&&array[start]==array[end]){
                return findMin(array,start,end);
            }
            if (array[mid]>=array[start]){
                start = mid;
            }else if (array[mid]<=array[end]){
                end = mid;
            }
        }
        return array[mid];
    }
    public int findMin(int[] array,int start,int end){
        int result = array[start];
        for (int i= start;i<=end;i++){
            result = Math.min(result,array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3};
        System.out.println(new MinNumInRotatingArray().minNumberInRotateArray(a));
    }
}
