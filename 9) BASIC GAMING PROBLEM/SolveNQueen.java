import java.util.List;
import java.util.ArrayList;

public class SolveNQueen {
    public static boolean isSafe(int row, int col,char[][] board) {
        //horizontal and vertical
        for(int i=0;i<board.length;i++) {
            if(board[i][col] == 'Q')
                return false;
            if(board[row][i] == 'Q')
                return false;
        }

        //top left
        for(int r=row,c=col;r>=0 && c>=0;r--,c--) {
            if(board[r][c]=='Q')
                return false;
        }

        //top right
        for(int r=row,c=col;r>=0 && c<board.length;r--,c++) {
            if(board[r][c]=='Q')
                return false;
        }

        //bottom left
        for(int r=row,c=col;r<board.length && c>=0;r++,c--) {
            if(board[r][c]=='Q')
                return false;
        }

        //bottom right
        for(int r=row,c=col;r<board.length && c<board.length;r++,c++) {
            if(board[r][c]=='Q')
                return false;
        }  
        return true;
    }

    public static void saveBoard(char[][] board,List<List<String>> allBoard) {
        String row = "";
        List<String> newBoard = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            row = "";
            for(int j=0;j<board.length;j++) {
                if(board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoard.add(newBoard);
    }

    public static void helper(char[][] board,List<List<String>> allBoard,int col) {
        if(col == board.length) {
            saveBoard(board,allBoard);
            return;
        }
        for(int row = 0;row < board.length;row++) {
            if(isSafe(row,col,board)) {
                board[row][col] = 'Q';
                helper(board, allBoard, col+1);
                board[row][col] = '.';
            }
        }
    }
    public static List<List<String>> solveNQueen(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, allBoard, 0);
        return allBoard;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(solveNQueen(n));
    }
}
