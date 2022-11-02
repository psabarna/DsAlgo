package algo.expert.recursion.hard;

import java.util.ArrayList;

public class Sudoku {
    public static ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
        //solveSudoku(board, 0, 0);
        solveSudoku1(board, 0, 0);
        //solveSudoku2(board, 0, 0);
        return board;
    }


    public static boolean solveSudoku(ArrayList<ArrayList<Integer>> board, int row, int col) {
        if(col==board.get(0).size()){
            row+=1;
            col=0;
            if(row==board.size()){
                return true;
            }
        }
        if(board.get(row).get(col)==0){
            return tryDigitAtPos(row, col, board);
        }
        return solveSudoku(board, row, col+1);
    }

    public static boolean solveSudoku1(ArrayList<ArrayList<Integer>> board, int row, int col) {
        if (col == board.get(0).size()) {
            row += 1;
            col = 0;
            if (row == board.size()) {
                return true;
            }
        }
        if (board.get(row).get(col) != 0) {
            return solveSudoku1(board, row, col + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (isValidAtPos(board, row, col, k)) {
                    board.get(row).set(col, k);
                    if (solveSudoku1(board, row, col + 1)) {
                        return true;
                    }
                    board.get(row).set(col, 0);
                }
            }
            return false;
        }
    }


    public static boolean solveSudoku2(ArrayList<ArrayList<Integer>> board, int row, int col) {
        for (int i = row; i < board.size(); i++, col = 0) {
            for (int j = col; j < board.get(0).size(); j++) {
                if (board.get(i).get(j) != 0) {
                    continue;
                }

                for (int k = 1; k <= 9; k++) {
                    if (isValidAtPos(board, i, j, k)) {
                        board.get(i).set(j, k);
                        if (solveSudoku2(board, i, j + 1)) {
                            return true;
                        }
                        board.get(i).set(j, 0);
                    }
                }
                return false;

            }
        }
        return true;
    }

    public static boolean tryDigitAtPos(int row, int col, ArrayList<ArrayList<Integer>> board){
        for(int i=1; i<=9; i++){
            if(isValidAtPos(board, row, col, i)){
                board.get(row).set(col, i);
                if(solveSudoku(board, row, col+1)){
                    return true;
                }
            }
        }
        board.get(row).set(col,0);
        return false;
    }
    public static boolean isValidAtPos(ArrayList<ArrayList<Integer>> board, int row, int col, int val){
        ArrayList<Integer> rowData =  board.get(row);
        if(rowData.contains(val)){
            return false;
        }
        for(int r=0; r<board.size(); r++){
            if(board.get(r).get(col)==val){
                return false;
            }
        }
        //check subgrid condition
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;
        for(int i =0; i<3 ; i++){
            for (int j =0; j<3; j++){
                int rowId = rowStart+i;
                int colId = colStart+j;
                if(board.get(rowId).get(colId)==val){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] inputValues =
                new int[][] {
                        {7, 8, 0, 4, 0, 0, 1, 2, 0},
                        {6, 0, 0, 0, 7, 5, 0, 0, 9},
                        {0, 0, 0, 6, 0, 1, 0, 7, 8},
                        {0, 0, 7, 0, 4, 0, 2, 6, 0},
                        {0, 0, 1, 0, 5, 0, 9, 3, 0},
                        {9, 0, 4, 0, 6, 0, 0, 0, 5},
                        {0, 7, 0, 3, 0, 0, 0, 1, 2},
                        {1, 2, 0, 0, 0, 7, 4, 0, 0},
                        {0, 4, 9, 2, 0, 6, 0, 0, 7}
                };
        int[][] expectedValues =
                new int[][] {
                        {7, 8, 5, 4, 3, 9, 1, 2, 6},
                        {6, 1, 2, 8, 7, 5, 3, 4, 9},
                        {4, 9, 3, 6, 2, 1, 5, 7, 8},
                        {8, 5, 7, 9, 4, 3, 2, 6, 1},
                        {2, 6, 1, 7, 5, 8, 9, 3, 4},
                        {9, 3, 4, 1, 6, 2, 7, 8, 5},
                        {5, 7, 8, 3, 9, 4, 6, 1, 2},
                        {1, 2, 6, 5, 8, 7, 4, 9, 3},
                        {3, 4, 9, 2, 1, 6, 8, 5, 7}
                };

        var input = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < inputValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < inputValues[i].length; j++) {
                row.add(inputValues[i][j]);
            }
            input.add(row);
        }

        var expected = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < expectedValues.length; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < expectedValues[i].length; j++) {
                row.add(expectedValues[i][j]);
            }
            expected.add(row);
        }

        var actual = solveSudoku(input);
        for(int i =0; i < actual.size(); i++){
            for(int j=0; j<actual.get(0).size(); j++){
                System.out.print(actual.get(i).get(j));
            }
            System.out.println();
        }

    }
}
