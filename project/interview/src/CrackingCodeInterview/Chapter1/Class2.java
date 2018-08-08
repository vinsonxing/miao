package CrackingCodeInterview.Chapter1;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/27/14
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class2 {
  public static String reverse(String str)
  {
    if(str == null)
    {
      return null;
    }
    if(str.length() == 1)
    {
      return str;
    }
    return str.charAt(str.length()-1) + reverse(str.substring(0, str.length() - 1));
  }

  public static void main(String[] args)
  {
    System.out.println(reverse("asdfkki"));
  }
}
