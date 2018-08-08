package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 12/13/14
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
public class RemoveDuplicate {
  private static String str="ABCAAAD";

  public static String compact(String str){

    String res="";

    boolean []arr = new boolean[256];

    Arrays.fill(arr, false);

    for(int i=0;i<str.length();i++){

      int x=str.charAt(i);

      System.out.println(x);

      if(arr[x]==false){
        res+=str.charAt(i);
        arr[x]=true;
      }

    }

    return res;
  }

  public static void main(String args[]){
    System.out.println(""+compact(str));
  }
}
