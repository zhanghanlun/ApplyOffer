package code._64数据流中的中位数;

import java.util.ArrayList;
import java.util.Collections;

public class GetMedian {

    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        Collections.sort(list);
        if (list.size() == 0) {
            return 0.0;
        }
        if (list.size() % 2 == 0) {
            int a = list.get(list.size() / 2);
            int b = list.get(list.size() / 2 - 1);
            double result = (a + b) / 2.0;
            return result;
        } else {
            int a = list.get(list.size() / 2);
            return (double) a;
        }
    }
}
