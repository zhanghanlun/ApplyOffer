//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
public class Solution {
    //普通解法
    public int NumberOf1(int n) {
        int count=0;
        int flag=1;
        while(flag!=0){
            if((flag&n)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }
    //更好的解法
     public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
