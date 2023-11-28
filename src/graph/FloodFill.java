package graph;

public class FloodFill {

  public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    floodFill(image, sr, sc, color, image[sr][sc], visited);
    return image;
  }

  public static void floodFill(int[][] image, int sr, int sc, int color, int oldColor, boolean[][] visited) {
    if(sr<0 || sc<0 || sr>=image.length || sc>= image[0].length || image[sr][sc]!= oldColor || visited[sr][sc]){
      return;
    }
    image[sr][sc] = color;
    visited[sr][sc] = true;
    floodFill(image, sr+1, sc, color, oldColor, visited);
    floodFill(image, sr-1, sc, color, oldColor, visited);
    floodFill(image, sr, sc-1, color, oldColor, visited);
    floodFill(image, sr, sc+1, color, oldColor, visited);

  }

  public static void main(String[] args) {
   int[][] image = {{0,0,0},{0,0,0}};
   image = floodFill(image, 0,0,0 );
   for(int[] row: image){
     for(int i: row){
       System.out.print(i+" ");
     }
     System.out.println();
   }
  }

}
