import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class SudokuBoard {
    public static int[][] board = new int[9][9];
    public static void main(String[] args) {
        createBoard();
        displayBoard();
    }
    
    public static void createBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
        fillDiagonalFirst(0,0);
        fillCell(0, 0);
    }

    public static void displayBoard() {
        System.out.println("\nHello, Here is a solved Sudoku Puzzle: ");
        for (int k = 0; k <= 6; k+=3) {
            System.out.println("+-------+-------+-------+");
            for (int i = 0+k; i < 3 + k; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (j % 3 == 0){
                        System.out.print("| ");
                    }
                    System.out.print(board[i][j] + " ");
                }
                System.out.println("|");
            }
        }
        System.out.println("+-------+-------+-------+");
    }

    public static void fillDiagonalFirst(int r, int c) { 
        ArrayList<Integer> arr = new ArrayList<Integer> (generateRandomArray());
        int startR = r;
        int startC = c;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[startR+i][startC+j] = arr.get(0);
                arr.remove(0);
            }
        }
        if (r <= 3 || c <= 3)
        fillDiagonalFirst(r+3, c+3);
    }

    public static boolean fillCell(int r, int c) {
        if (r == 9)
            return true;
        if (c == 9)
            return fillCell(r+1, 0);
        if (board[r][c] != 0) {
            return fillCell(r, c+1);
        }
        ArrayList<Integer> check = new ArrayList<Integer>();
        for (int i = 0; i < board.length; i++)
            check.add(board[i][c]);
        for (int i = 0; i < board[0].length; i++)
            if (!check.contains(board[r][i]))
                check.add(board[r][i]);
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int i = 0; i < check.size(); i++) {
            nums.remove((Integer)check.get(i));
        }
        Collections.shuffle(nums);
        while (nums.size() > 0){
            board[r][c] = nums.remove(0);
            if (check3x3(r,c)) {
                if (fillCell(r,c+1))
                    return true;
            }
        }
        board[r][c] = 0;
        return false;
    }

    public static boolean check3x3(int row, int col) {
        int refRow = row - row%3;
        int refCol = col - col%3;
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[refRow+i][refCol+j] != 0 && refRow+i != row && refCol+j != col)
                numList.add(board[refRow+i][refCol+j]);
        if (numList.contains(board[row][col]))
            return false;
        return true;
    }

    public static ArrayList<Integer> generateRandomArray() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);
        return arr;
    }
}