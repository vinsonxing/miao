/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-9
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
public class TwoDimentionArray {
  private static int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public static void main(String[] args){
    for(int i=0; i<MOVE.length; i++) {
      for(int j=0; j<MOVE[0].length; j++)
        System.out.print(MOVE[i][j] + " ");
      System.out.println();
    }
  }
}
