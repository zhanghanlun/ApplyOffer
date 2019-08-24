package code._20顺时针打印矩阵;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && columns > start * 2) {
            printCircle(matrix, rows, columns, start, result);
            start++;
        }
        return result;
    }

    private void printCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> list) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for (int i = start; i <= endX; i++) {
            list.add(matrix[start][i]);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                list.add(matrix[endY][i]);
            }
        }
        if (start + 1 < endY && start < endX) {
            for (int i = endY - 1; i > start; i--) {
                list.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,},{3,4},{5,6},{7,8}};
        ArrayList list = new PrintMatrix().printMatrix(matrix);
        System.out.println(list);
    }
}
