package code._44扑克牌顺序;


import java.util.ArrayList;
import java.util.Collections;

public class isContinuous {

    public boolean isContinuous(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        if (numbers == null || numbers.length <= 0){
            return false;
        }
        int zeroCount = 0;
        for (int num : numbers) {
            if (num == 0) {
                zeroCount++;
            } else {
                list.add(num);
            }
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                return false;
            } else if (list.get(i) != list.get(i - 1) + 1) {
                zeroCount = zeroCount - (list.get(i) - list.get(i - 1) - 1);
            }
        }
        return zeroCount >= 0;
    }

    public static void main(String[] args){
        int[] array = {1,0,0,1,0};
        System.out.println(new isContinuous().isContinuous(array));
    }
}
