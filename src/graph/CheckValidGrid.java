package graph;
/*
https://leetcode.com/problems/check-knight-tour-configuration/description/
 */
public class CheckValidGrid {
    public static boolean checkValidGrid(int[][] grid) {
        return checkValidGrid(grid, 0, 0, 0);
    }
    public static boolean checkValidGrid(int[][] grid, int i, int j, int move){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] != move){
            return false;
        }
        if(move == (grid.length*grid[0].length)-1){
            return true;
        }
        return checkValidGrid(grid, i+2, j+1, move+1) ||
                checkValidGrid(grid, i+2, j-1, move+1) ||
                checkValidGrid(grid, i-2, j+1, move+1) ||
                checkValidGrid(grid, i-2, j-1, move+1) ||

                checkValidGrid(grid, i+1, j+2, move+1) ||
                checkValidGrid(grid, i+1, j-2, move+1) ||
                checkValidGrid(grid, i-1, j+2, move+1) ||
                checkValidGrid(grid, i-1, j-2, move+1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}};
        System.out.println(checkValidGrid(grid));
    }
}
