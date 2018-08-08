package CrackingCodeInterview.Chapter1;

public class Class1 {
  static boolean isUniqueString(String str)
  {
    if(str.length() == 1)
    {
      return true;
    }
    String initial = str.substring(0,1);
    String sub = str.substring(1, str.length());
    if(sub.contains(initial))
    {
      return false;
    }
    return isUniqueString(sub);
  }
  // solution w/o recursion
  static boolean isUniqueString1(String str)
  {
    boolean[] res = new boolean[256];
    for(int i=0; i<str.length(); i++)
    {
      int value = str.charAt(i);
      if(res[value]) return false;
      else
      {
        res[i] = true;
      }
    }
    return true;
  }

  public static void main(String[] args)
  {
    String test = "JKLDSFTUIOP";
    boolean res = isUniqueString1(test);
    if(res)
    {
      System.out.println(test + " is unique");
    }
    else
    {
      System.out.println(test + " is NOT unique");
    }
//    int z = 'z';
//    System.out.println(z);
  }
}
