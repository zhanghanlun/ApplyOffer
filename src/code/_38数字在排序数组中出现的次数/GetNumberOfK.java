package code._38数字在排序数组中出现的次数;

public class GetNumberOfK {


    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getEndK(array, k, 0, array.length - 1);
        if (lastK == firstK && lastK == -1){
            return 0;
        }
        return lastK - firstK + 1;
    }

    public int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == k && (mid == 0 || array[mid - 1] != k)) {
            return mid;
        } else if ((array[mid] == k && array[mid - 1] == k) || array[mid] > k) {
            end = mid - 1;
        } else if (array[mid] < k) {
            start = mid + 1;
        }
        return getFirstK(array, k, start, end);
    }

    public int getEndK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] == k && (mid == array.length - 1 || array[mid + 1] != k)) {
            return mid;
        } else if ((array[mid] == k && array[mid + 1] == k) || array[mid] < k) {
            start = mid + 1;
        } else if (array[mid] > k) {
            end = mid - 1;
        }
        return getEndK(array, k, start, end);
    }

    public static void main(String[] args){
        int[] array={1,1,1,1,1,1};
        System.out.println(new GetNumberOfK().GetNumberOfK(array,3));
    }
}
