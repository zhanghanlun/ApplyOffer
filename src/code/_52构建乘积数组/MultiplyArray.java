package code._52构建乘积数组;

public class MultiplyArray {

    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if (A.length <= 1) {
            return B;
        }
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int count = 1;
        for (int i = A.length - 1; i >= 1; i--) {
            count = count * A[i];
            B[i - 1] = B[i - 1] * count;
        }
        return B;
    }

    public static void main(String[] args){
        int[] A = {1};
        int[] B = new MultiplyArray().multiply(A);
        for(int num:B){
            System.out.println(num);
        }
    }
}
