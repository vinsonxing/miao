package CrackingCodeInterview.Chapter1;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/27/14
 * Time: 10:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class8 {
  public static boolean isSubstring(String s1, String s2)
  {
    if(s1.indexOf(s2) != -1)
    {
      return true;
    }
    return false;
  }
  public static boolean isRotation(String s1, String s2)
  {
    if(s1.length() != s2.length())
    {
      return false;
    }
    String s1s1 = s1 + s1;
    return isSubstring(s1s1, s2);
  }
  public static void main(String[] args){
    String a = "abc";
    String b= "cba";
    System.out.println(isRotation(a, b));
  }
}
