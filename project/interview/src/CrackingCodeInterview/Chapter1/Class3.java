package CrackingCodeInterview.Chapter1;

import java.util.HashMap;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/27/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class3 {
  public static boolean isPermutation(String str1, String str2)
  {
    Map<String, Integer> map1 = convert(str1);
    Map<String, Integer> map2 = convert(str2);
    if(map1.equals(map2))
    {
      return true;
    }
    return false;
  }

  static Map convert(String str)
  {
    Map<String, Integer> map = new HashMap<String, Integer>();
    for(int i=0; i<str.length(); i++)
    {
      if(map.get(str.substring(i, i+1)) == null)
      {
        map.put(str.substring(i, i+1), 1);
      }
      else
      {
        int val  = map.get(str.substring(i, i+1));
        map.put(str.substring(i, i+1), val+1);
      }
    }
    return map;
  }

  public static void main(String[] args)
  {
    String str1 = "dfawfsf";
    String str2 = "safdfwf";
    boolean res = isPermutation(str1, str2);
    if(res)
    {
      System.out.println("yes");
    }
    else {
      System.out.println("no");
    }
  }
}
