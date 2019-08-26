package code._36数组中的逆序对;

public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return inverse(array, copy, 0, array.length - 1);
    }

    private int inverse(int[] data, int[] copy, int start, int end) {
        if (start>end){
            return 0;
        }
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = inverse(copy, data, start, start + length)%1000000007;
        int right = inverse(copy, data, start + length + 1, end)%1000000007;
        int i = start + length;
        int j = end;
        int copyIndex = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[copyIndex--] = data[i--];
                count = count + j - start - length;
            } else {
                copy[copyIndex--] = data[j--];
            }
            if (count > 1000000007){
                count = count%1000000007;
            }
        }
        while (i >= start) {
            copy[copyIndex--] = data[i];
            i--;
        }
        while (j >= start + length + 1) {
            copy[copyIndex--] = data[j];
            j--;
        }
        return (left + right + count)%1000000007;
    }

    public static void main(String[] args){
        int[] a ={1,2,3,4,0};
        System.out.println(new InversePairs().InversePairs(a));
    }
}
