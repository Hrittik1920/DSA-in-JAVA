public class SudokuSolver {
    public static boolean isSafe(char[][] board,int row,int col,int number) {
        //horizontal & vertical
        for(int i=0;i<board.length;i++) {
            if(board[i][col] == (char)(number + '0'))
                return false;
            if(board[row][i] == (char)(number + '0'))
                return false;
        }
        
        // Grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr;i<sr+3;i++) {
            for(int j=sc;j<sc+3;j++) {
                if(board[i][j] == (char)(number + '0'))
                    return false;
            }
        }
        return true;
    }
    public static boolean helper(char[][] board,int row,int col) {
        if(row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;
        if(col != board.length-1) {
            nrow = row;
            ncol = col + 1;
        } else {
            nrow = row + 1;
            ncol = 0;
        }

        if(board[row][col] != '.') {
            if(helper(board, nrow, ncol)) {
                return true;
            }
        } else {
            for(int i=1;i<=9;i++) {
                if(isSafe(board,row,col,i)) {
                    board[row][col] = (char)(i + '0');
                    if(helper(board, nrow, ncol)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    } 
                }
            }
        }
        return false;
    }
    public static void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
    public static void main(String[] args) {
        char[][]sudoku = {{'.','4','.','1','5','.','.','8','3'},
                          {'.','3','.','.','6','.','5','.','.'},
                          {'6','.','.','.','.','.','.','.','9'},
                          {'.','5','.','.','.','.','.','.','.'},
                          {'1','.','.','7','.','8','.','.','2'},
                          {'.','.','.','.','.','.','.','6','.'},
                          {'5','.','.','.','.','.','.','.','4'},
                          {'.','.','4','.','8','.','.','7','.'},
                          {'8','6','.','.','2','4','.','9','.'}};
        
        for(int i=0;i<sudoku.length;i++) {
            for(int j=0;j<sudoku.length;j++) {
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println();
        }
        solveSudoku(sudoku);

        System.out.println();
        for(int i=0;i<sudoku.length;i++) {
            for(int j=0;j<sudoku.length;j++) {
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
