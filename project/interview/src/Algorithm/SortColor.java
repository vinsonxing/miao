package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class SortColor {
  public static void swap(int[] A, int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  static void sortColors(int A[], int n) {
    int red = 0;
    int blue = n-1;
    while(A[red] == 0){red++;}
    while(A[blue]==2){blue--;}

    int i=red;
    while(i<=blue){
      if (A[i]==0 && i>red) {swap(A,i,red);red++;continue;}
      if (A[i]==2) {swap(A,i,blue);blue--;continue;}
      i++;
    }
  }
  public static void main(String[] args){
    int[] A = {1, 2, 0, 1, 0, 2};
    sortColors(A, A.length);
    for(int i:A){
      System.out.print(i+" ");
    }
  }
}
