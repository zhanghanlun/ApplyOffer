package code._42左旋转字符串;

public class LeftRotateString {

    public String LeftRotateString(String str, int n) {
        if (str == null) {
            return null;
        }
        if (n <= 0) {
            return str;
        }
        n = n % str.length();
        return str.substring(n) + str.substring(0, n);
    }

    public static void main(String[] args) {
        String a = "abcdefg";
        System.out.println(a.substring(1));
        System.out.println(new LeftRotateString().LeftRotateString(a, 3));
    }
}
