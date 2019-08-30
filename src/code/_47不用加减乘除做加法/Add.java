package code._47不用加减乘除做加法;


public class Add {

    public int Add(int num1,int num2) {
        int sum;
        int carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }

    public static void main(String[] args){
        System.out.println(new Add().Add(2,3));
    }
}
