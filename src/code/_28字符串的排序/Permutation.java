package code._28字符串的排序;

import java.util.*;

public class Permutation {

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Set<String> stringSet = new HashSet<>();
        permu(chars,0,chars.length,stringSet);
        ArrayList<String> result = new ArrayList<>(stringSet);
        Collections.sort(result);
        return result;
    }

    private void permu(char[] chars, int start, int len, Set<String> stringSet) {
        if (start == len - 1) {
            stringSet.add(String.valueOf(chars));
        } else {
            for (int i = start; i < len; i++) {
                swap(chars, start, i);
                permu(chars, start + 1, len, stringSet);
                swap(chars, start, i);
            }
        }
    }

    private void swap (char[] data,int i,int j){
        char temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args){
        System.out.println(new Permutation().Permutation("abc"));
    }

}
