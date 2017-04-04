import java.util.LinkedList;
import java.util.List;

public class NQueens {

    /**
     * Creates a deep copy of the input array and returns it
     */
    private static char[][] copyOf(char[][] A) {
        char[][] B = new char[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            System.arraycopy(A[i], 0, B[i], 0, A[0].length);
        return B;
    }

    public static List<char[][]> nQueensSolutions(int n) {
        char[][] curr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                curr[i][j] = '.';
            }
        }
        return placeQ(n, curr, new LinkedList<>(), 0,0);
    }

    public static List<char[][]> placeQ(int n, char[][] board, List<char[][]> history, int iOld, int jOld){
        if (n == 0) {
            history.add(copyOf(board));
            return history;
        }
        for (int i = iOld; i < board.length; i++) {
            for (int j = jOld; j < board.length; j++) {
                if (isValid(i, j, board)) {
                    board[i][j] = 'Q';
                    placeQ(n-1, board, history, i, j);
                    board[i][j] = '.';
                }
            jOld=0;
            }
        }
        return history;
    }

    //check if square is valid. Should instead set up board to use a third char
    public static Boolean isValid(int i, int j, char[][] board){
        for (char x: board[i]) {
            if (x == 'Q'){
                return false;
            }
        }
        for (char[] y : board) {
            if (y[j] == 'Q') {
                return false;
            }
        }
        int k=0;
        while (i - k >= 0 && j-k >=0){
            if (board[i-k][j-k] == 'Q'){
                return false;
            }
            k++;
        }
        k = 0;
        while (i - k>= 0 && j+k <board.length){
            if (board[i-k][j+k] == 'Q'){
                return false;
            }
            k++;
        }
        k=0;
        while (i + k < board.length && j-k >=0){
            if (board[i+k][j-k] == 'Q'){
                return false;
            }
            k++;
        }
        k=0;
        while (i + k < board.length && j+k <board.length){
            if (board[i+k][j+k] == 'Q'){
                return false;
            }
            k++;
        }
        return true;
    }
}
