package code._10二进制数中的1;

public class NumberOf1 {

    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag)!=0){
                count++;
            }
            flag = flag<<1;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = -1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(new NumberOf1().NumberOf1(a));
    }
}
