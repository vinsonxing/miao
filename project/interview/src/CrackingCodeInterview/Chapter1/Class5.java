package CrackingCodeInterview.Chapter1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/27/14
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class5 {
  public static String convert(String str)
  {
    char[] array = str.toCharArray();
    char[] newArray = new char[array.length * 2];
    int newIndex = 0;
    for(int i=0; i<array.length;)
    {
      int count = 1, j;
      for(j=i; j<array.length-1; j++)
      {
        if(array[j] == array[j+1])
        {
          count++;
        }
        else
        {
          break;
        }
      }
      newArray[newIndex++] = array[i];
      char[] countArray = Integer.toString(count).toCharArray();

      for(char c:countArray)
      {
        newArray[newIndex++] = c;
      }
      i=i+count;
    }
    if(str.length() <= String.valueOf(newArray).trim().length())
    {
      return str;
    }
    return  String.valueOf(newArray).trim();
  }

  public static void main(String[] args)
  {
    String test = "ddddddddddddjjjkkkkkkkkkkkkkkkkkkkkkkkllllllssssss";
    System.out.println(convert(test));
  }
}
