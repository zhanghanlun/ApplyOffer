package code._40数组中只出现一次的数字;

public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xorNum = array[0];
        for (int i = 1; i < array.length; i++) {
            xorNum = xorNum ^ array[i];
        }
        int indexBit = findFirstOneBit(xorNum);
        num1[0] = 0;
        num2[0] = 0;
        for (int num : array) {
            if (isOneInTheBit(num, indexBit)) {
                num1[0] = num1[0] ^ num;
            } else {
                num2[0] = num2[0] ^ num;
            }
        }
    }

    private int findFirstOneBit(int num) {
        int indexBit = 0;
        while ((num & 1) == 0 && indexBit < Integer.bitCount(num)) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }

    private boolean isOneInTheBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,3,4,5,6,6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new FindNumsAppearOnce().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
