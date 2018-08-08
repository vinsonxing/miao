package Algorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 1:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class FindAnagram {
  static String sorted(String str){
    char[] array = str.toCharArray();
    Arrays.sort(array);
    return new String(array);
  }
  static void printList(List<String> arr) {
    for(String str: arr){
      System.out.println(str + " ");
    }
  }
  static void findAnagram(String[] array){
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    for(String str:array){
      String key = sorted(str);

      if(!map.containsKey(key)){
        List<String> val = new ArrayList<String>();
        val.add(str);
        map.put(key, val);
      } else {
        List<String> val = map.get(key);
        val.add(str);
      }
    }
    for(Map.Entry entry : map.entrySet()){
      List<String> val = (List<String>)entry.getValue();
      if(val.size() > 1){
         printList(val);
      }
    }
  }
  public static void main(String[] args) {
    String[] array = {"abc", "bca", "dfsd", "cba"};
    findAnagram(array);
  }
}
