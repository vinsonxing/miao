package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/5/14
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatrixSearch {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null)
      return false;
    int rows,rowe,cs,ce;
    rows = cs = 0;
    rowe = matrix.length;
    ce = matrix[0].length;
    while(rows < rowe && cs < ce && ce > 0 && rowe > 0){
      if (target == matrix[rows][ce - 1] || target == matrix[rowe - 1][cs])
        return true;
      else if (target < matrix[rows][ce - 1] && target < matrix[rowe - 1][cs]){
        rowe--;
        ce--;
      }
      else if (target > matrix[rows][ce - 1] && target > matrix[rowe - 1][cs]){
        rows++;
        cs++;
      }
      else if (target < matrix[rows][ce - 1] && target > matrix[rowe - 1][cs]){
        cs++;
        ce--;
      }
      else if (target > matrix[rows][ce - 1] && target < matrix[rowe - 1][cs]){
        rows++;
        rowe--;
      }
    }
    return false;
  }
}
