package code._55字符流中第一个不重复的字符;


public class FirstAppearingOnce {

    private int[] occur = new int[256];

    private int index = 1;


    public void Insert(char ch) {
        if (occur[ch] == 0) {
            occur[ch] = index;
        } else {
            occur[ch] = -2;
        }
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char ch = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (occur[i] > 0 && occur[i] < min) {
                ch = (char) i;
                min = occur[i];
            }
        }
        return ch;
    }

    public static void main(String[] args){
        FirstAppearingOnce instence = new FirstAppearingOnce();
        instence.Insert('g');
        System.out.println(instence.FirstAppearingOnce());
    }
}
