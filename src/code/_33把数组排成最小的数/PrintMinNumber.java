package code._33把数组排成最小的数;

import java.util.ArrayList;

public class PrintMinNumber {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }
        list.sort((String o1, String o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder = new StringBuilder();
        for (String num : list) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        int[] nums = {3,32,321};
        ArrayList<Integer> list = new ArrayList<>();
        for (int num :nums){
            list.add(num);
        }
        list.sort(Integer::compareTo);
        System.out.println(list);
    }
}
