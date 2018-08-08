package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 12:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class MergeArray {
//  public static void main(String[] args) {
//    int[] A = new int[]{2, 4, 6, 11, 12};
//    int[] B = new int[] {1, 3, 7, 9};
//    int[] C = new int[A.length+B.length];
//    merge(A, B, C, A.length, B.length);
//    for(int i:C)
//    {
//      System.out.println(i +"");
//    }
//  }
//
//  static void merge(int[] A, int[] B, int[] C, int m, int n)
//  {
//    int i = m-1;
//    int j= n-1;
//    int k = m+n-1;
//    while(k >= 0){
//      if(i>=0 && A[i] > B[j]){
//        C[k--] = A[i--];
//      } else {
//        C[k--] = B[j--];
//      }
//    }
//  }

  public static void main(String[] args) {
    int[] A = {1,2,3,4};
    int[] B = {2,4,6};
    int[] C = new int[A.length + B.length];
    merge(A, B, C);
    for (int i : C) {
      System.out.print(i + ",");
    }

  }
  public static void merge(int A[], int B[], int[] C) {
    int m = A.length;
    int n = B.length;

    while(m > 0 && n > 0){
      if(A[m-1] > B[n-1]){
        C[m+n-1] = A[m-1];
        m--;
      }else{
        C[m+n-1] = B[n-1];
        n--;
      }
    }

    while(n > 0){
      C[m+n-1] = B[n-1];
      n--;
    }

    while(m > 0){
      C[m+n-1] = A[m-1];
      m--;
    }
  }
}
