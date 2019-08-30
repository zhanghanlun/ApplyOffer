package code._67机器人的运动范围;

public class MachineMovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 && cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return getMaxCount(threshold, rows, cols, 0, 0, visited);
    }

    private int getMaxCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols &&
                getDigitNum(row) + getDigitNum(col) <= threshold && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            count = 1 + getMaxCount(threshold, rows, cols, row, col + 1, visited)
                    + getMaxCount(threshold, rows, cols, row, col - 1, visited)
                    + getMaxCount(threshold, rows, cols, row + 1, col, visited)
                    + getMaxCount(threshold, rows, cols, row - 1, col, visited);
        }
        return count;
    }

    private int getDigitNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
