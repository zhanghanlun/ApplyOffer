package code._54表示数值的字符串;

public class IsNumeric {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int index = 0;
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }
        if (index >= str.length) {
            return false;
        }
        int indexTemp = isNum(str,index);
        index = indexTemp;
        if (index < str.length) {
            if (str[index] == '.') {
                index = index + 1;
                indexTemp = isNum(str, index);
                if (indexTemp == index){
                    return false;
                }
                index = indexTemp;
            }
            if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
                index++;
                if (index < str.length && (str[index] == '+' || str[index] == '-')) {
                    index++;
                }
                indexTemp = isNum(str, index);
                if (index == indexTemp) {
                    return false;
                }
                index = indexTemp;
            }
        }
        return index >= str.length;
    }

    private int isNum(char[] str,int index){
        while (index < str.length) {
            if (str[index] >= '0' && str[index] <= '9') {
                index++;
            } else {
                break;
            }
        }
        return index;
    }

    public static void main(String[] args){
        String str = "-.54";
        System.out.println(new IsNumeric().isNumeric(str.toCharArray()));
    }
}
