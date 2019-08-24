package code._12调整数组顺序;

import java.util.LinkedList;
import java.util.Queue;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        //奇数
        LinkedList<Integer> odd = new LinkedList<>();
        //偶数
        LinkedList<Integer> even = new LinkedList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        for (int i = 0;i<array.length;i++){
            if (odd.size() > 0) {
                array[i] = odd.getFirst();
                odd.removeFirst();
            }else{
                array[i] = even.getFirst();
                even.removeFirst();
            }
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        new ReOrderArray().reOrderArray(array);
        for (int a:array){
            System.out.println(a);
        }
    }
}
