package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-16
 * Time: 下午11:56
 * To change this template use File | Settings | File Templates.
 */
public class BSearch {
  public static int search(int a[], int l, int u, int x) {
    while(l<=u)
    {
      int m = (l+u)/2 ;
      if(x==a[m])
      {
        return m;
      }
      else if(a[l] <= a[m])
      {
        if(x>a[m])
        {
          l=m+1;
        } else if(x>=a[l])
        {
          u=m-1;
        }
        else l=m+1;
      }
      else if(x<a[m]) u=m-1;
      else if(x<=a[u]) l=m+1;
      else u=m-1;
    }
  return -1;
  }
  public static void main(String[] args){
    int[] test = new int[]{6,7,8,9,1};
    int res = search(test, 0, test.length-1, 1);
    System.out.println("result is "+res);
  }
}
