package algo.expert.recursion.veryhard;

/**
 * Given a number n, find the number of non-attacking placements of n queens on an n*n chess board
 * non-attacking placements is when no queen can attack any queen
 */
public class NonAttackingQueens {
    static int validQueenPlacements = 0;
    public static int nonAttackingQueens(int n) {
        int[] columnPlacements = new int[n];
        nonAttackingPlacement(0,  n,  columnPlacements);
        return validQueenPlacements;
    }
    public static void nonAttackingPlacement(int row, int n, int[] columnPlacements){
        if(row==n){
            validQueenPlacements+= 1;
        }

        for(int col =0; col<n; col++){
            if(isNonAttackingPlacement(columnPlacements, row, col)){
                columnPlacements[row] = col;
                nonAttackingPlacement(row+1,n, columnPlacements);
            }
        }
    }

    public static boolean isNonAttackingPlacement( int[] columnPlacements, int row, int column) {
        for(int i = 0; i<row; i++){
            int prevColumn = columnPlacements[i];
            if(prevColumn==column || (Math.abs(column-prevColumn)==(row-i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nonAttackingQueens(4));
    }

}
