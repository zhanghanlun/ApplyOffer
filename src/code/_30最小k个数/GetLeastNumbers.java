package code._30最小k个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length < k || k == 0) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (Integer o1, Integer o2) -> o2 - o1);
        for (int num : input) {
            if (queue.size() != k) {
                queue.add(num);
            } else {
                if (queue.peek() > num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        result.addAll(queue);
        return result;
    }

    public static void main(String[] args){
        int[] a={4,5,1,6,2,7,3,8};
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(a,4));
    }
}
