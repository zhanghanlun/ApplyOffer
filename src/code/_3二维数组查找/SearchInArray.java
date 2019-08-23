package code._3二维数组查找;

public class SearchInArray {


    public static boolean Find(int target, int[][] array) {
        int row = 0;
        int column = array[0].length - 1;
        while (row <= array.length - 1 && column >= 0) {
            if (target == array[row][column]) {
                return true;
            } else if (target > array[row][column]) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args){

    }

}
