class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {

            // Fill left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Fill top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Fill right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // Fill bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}