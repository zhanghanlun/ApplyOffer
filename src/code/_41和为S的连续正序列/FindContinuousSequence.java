package code._41和为S的连续正序列;

import java.util.ArrayList;


/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int length = (sum + 1) / 2;
        int start = 1;
        int end = start + 1;
        int count = start + end;
        while (start < length) {
            if (count == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                result.add(list);
            }
            while (count > sum && start < length) {
                count = count - start;
                start++;
                if (count == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = start; i <= end; i++) {
                        list.add(i);
                    }
                    result.add(list);
                }
            }
            end++;
            count = count + end;
        }
        return result;
    }

    public static void main(String[] args){
        int sum = 15;
        System.out.println(new FindContinuousSequence().FindContinuousSequence(sum));
    }
}
