class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid digit works for this cell
                }
            }
        }
        return true; // no empty cells left -> solved
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;            // row check
            if (board[i][col] == c) return false;            // column check
            if (board[boxRow + i / 3][boxCol + i % 3] == c) return false; // box check
        }

        return true;
    }
}