package code._46求1到n的和;

public class Sum {


    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new Sum().Sum_Solution(10));
    }
}
