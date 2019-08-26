package code._35第一个只出现一次的字符;

import java.util.*;

public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (str == null){
            return -1;
        }
        char[] datas = str.toCharArray();
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < datas.length; i++) {
            if (map.get(datas[i]) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(1);
                map.put(datas[i], list);
            } else {
                int count = map.get(datas[i]).get(1) + 1;
                map.get(datas[i]).remove(1);
                map.get(datas[i]).add(count);
            }
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (Character character : map.keySet()){
            ArrayList<Integer> list = map.get(character);
            if (list.get(1) == 1){
                lists.add(map.get(character));
            }
        }
        if (lists.size()==0){
            return -1;
        }
        lists.sort(Comparator.comparing((ArrayList<Integer> o1)->o1.get(0)));
        return lists.get(0).get(0);
    }

    public static void main(String[] args){
        String str = "google";
        System.out.println(new FirstNotRepeatingChar().FirstNotRepeatingChar(str));
    }
}
