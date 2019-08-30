package code._53正则表达式匹配;

import java.util.regex.Pattern;

public class MatchRegular {


    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, 0, pattern, 0);
    }

    //时刻判断是否越界 strIndex!=str.length是不越界的判定条件
    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patIndex) {
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patIndex >= pattern.length) {
            return false;
        }
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if ((pattern[patIndex] == '.' && strIndex != str.length)
                    || (strIndex != str.length && str[strIndex] == pattern[patIndex])) {
                return matchCore(str, strIndex + 1, pattern, patIndex + 2)
                        || matchCore(str, strIndex + 1, pattern, patIndex)
                        || matchCore(str, strIndex, pattern, patIndex + 2);
            } else {
                return matchCore(str, strIndex, pattern, patIndex + 2);
            }
        }
        if ((strIndex != str.length && str[strIndex] == pattern[patIndex])
                || (strIndex != str.length && pattern[patIndex] == '.')) {
            return matchCore(str, strIndex + 1, pattern, patIndex + 1);
        }
        return false;
    }
    public static void main(String[] args){
        String str = "";
        String pat = ".*";
        System.out.println(new MatchRegular().match(str.toCharArray(),pat.toCharArray()));
    }
}
