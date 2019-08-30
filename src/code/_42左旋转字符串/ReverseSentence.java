package code._42左旋转字符串;

public class ReverseSentence {

    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] result = str.toCharArray();
        reverse(result, 0, result.length - 1);
        int start = 0;
        int end = 0;
        while (start < result.length && end < result.length + 1) {
            if (result[start] == ' ') {
                start++;
                end++;
            } else if (end == result.length || result[end] == ' ') {
                reverse(result, start, end - 1);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return String.valueOf(result);
    }

    private void reverse(char[] data, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++) {
            char temp = data[i];
            data[i] = data[end - i + start];
            data[end - i + start] = temp;
        }
    }

    public static void main(String[] args){
        String a = "abc de fg";
        System.out.println(new ReverseSentence().ReverseSentence(a));
    }
}
