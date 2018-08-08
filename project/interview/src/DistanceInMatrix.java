/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-9
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedList;
import java.util.Queue;
class Position{
  public int row, col, dis;
  public Position(int r, int c, int d){
    row = r;
    col = c;
    dis = d;
  }
}
public class DistanceInMatrix {
  public static void main(String[] args){
    int[][] matrix = {
            {-1, 0, -1},
            {-1, -1, -1},
            {-1, -1, -1}
    };
    int[][] dis = findMinimumDistanceToNearestZero(matrix);
    for(int[] arr : dis){
      for(int d : arr) System.out.print(d + " ");
      System.out.println();
    }
  }
  public static int[][] findMinimumDistanceToNearestZero(int[][] matrix){
    //step 1: initialize
    int totalRow = matrix.length, totalCol = matrix[0].length;
    int[][] dis = new int[totalRow][totalCol];
    boolean[][] vis = new boolean[totalRow][totalCol];
    Queue<Position> queue = new LinkedList<Position>();
    for(int i = 0; i < totalRow; ++i){
      for(int j = 0; j < totalCol; ++j){
        if(matrix[i][j] == 0){
          dis[i][j] = 0;
          vis[i][j] = true;
          queue.add(new Position(i, j, 0));
        }
      }
    }
    //step 2: BFS
    while(!queue.isEmpty()){
      Position pos = queue.poll();
      for(int i = 0; i < 4; ++i){
        int nr = pos.row + MOVE[i][0], nc = pos.col + MOVE[i][1];
        if(nr < 0 || nr >= totalRow || nc < 0 || nc >= totalCol) continue;
        if(vis[nr][nc]) continue;
        dis[nr][nc] = pos.dis + 1;
        vis[nr][nc] = true;
        queue.add(new Position(nr, nc, dis[nr][nc]));
      }
    }
    return dis;
  }
  private static int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
