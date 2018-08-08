package Algorithm;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class ReverseSentence {
  static String reverse(String[] str, StringBuilder sb) {
    if(str.length == 1) {
      return sb.append(str[0]).toString();
    }
    sb.append(str[str.length - 1]).append(" ");
    return reverse(Arrays.copyOf(str, str.length-1), sb);
  }

  public static void main(String[] args){
    String str = "hello   world";
    String[] test = str.split(" ");
    StringBuilder sb = new StringBuilder();
    System.out.println(reverse(test, sb));
  }
}
