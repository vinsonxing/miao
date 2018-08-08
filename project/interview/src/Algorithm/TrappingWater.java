package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class TrappingWater {
  public static void main(String[] args) {
//    int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
      int[] A = {2,0,2};
    System.out.println(trap(A));
  }
  public static int trap(int[] A) {
    if(A.length == 0){
      return 0;
    }

    // 先用DP算出left, right数组
    // left数组记录到当前i为止，左边最高的bar
    // right数组记录到当前i为止，右边最高的bar
    int[] left = new int[A.length];
    int[] right = new int[A.length];

    left[0] = A[0];
    for(int i=1; i<A.length; i++){
      left[i] = Math.max(left[i-1], A[i]);
    }
    right[A.length-1] = A[A.length-1];
    for(int i=A.length-2; i>=0; i--){
      right[i] = Math.max(right[i+1], A[i]);
    }

//      System.out.println(Arrays.toString(left));
//      System.out.println(Arrays.toString(right));

    int sum = 0;
    for(int i=1; i<A.length-1; i++){
      sum += Math.min(left[i], right[i]) - A[i];
    }

    return sum;
  }
}
