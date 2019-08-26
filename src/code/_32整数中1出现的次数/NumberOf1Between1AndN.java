package code._32整数中1出现的次数;

public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        char[] data = String.valueOf(n).toCharArray();
        return NumOf1(data, 0, data.length - 1);
    }

    private int NumOf1(char[] str, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            if (str[start] == '0') {
                return 0;
            } else {
                return 1;
            }
        }
        int numFirst = 0;
        int length = end - start + 1;
        int first = Integer.parseInt(String.valueOf(str[start]));
        if (first > 1) {
            numFirst = (int) Math.pow(10, length - 1);
        } else if (first == 1) {
            numFirst = Integer.parseInt(String.valueOf(str, start + 1, length - 1)) + 1;
        }
        int numOther = first * (length - 1) * (int) Math.pow(10, length - 2);
        int numEnd = NumOf1(str, start + 1, end);
        return numFirst + numOther + numEnd;
    }



    public static void main(String[] args){
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(13));
    }
}
