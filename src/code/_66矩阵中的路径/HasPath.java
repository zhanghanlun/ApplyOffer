package code._66矩阵中的路径;

public class HasPath {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || str == null || rows < 1 || cols < 1) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        int pathLen = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, pathLen, str, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols,
                                int row, int col, int pathLen, char[] str, boolean[] visited) {
        if (pathLen == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLen] && !visited[row * cols + col]) {
            pathLen++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, pathLen, str, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, pathLen, str, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, pathLen, str, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, pathLen, str, visited);
            if (!hasPath) {
                --pathLen;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args){
        String matrix = "ABCESFCSADEE";
        String str = "ABCB";
        System.out.println(new HasPath().hasPath(matrix.toCharArray(),3,4,str.toCharArray()));
    }
}
