package Algorithm;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/5/14
 * Time: 1:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class DuplicateCharsInString {
  public void findDuplicateChars(String str){

    Map<Character, Integer> dupMap = new HashMap<Character, Integer>();
    char[] chrs = str.toCharArray();
    for(Character ch:chrs){
      if(dupMap.containsKey(ch)){
        dupMap.put(ch, dupMap.get(ch)+1);
      } else {
        dupMap.put(ch, 1);
      }
    }
    Set<Character> keys = dupMap.keySet();
    for(Character ch:keys){
      if(dupMap.get(ch) > 1){
        System.out.println(ch+"--->"+dupMap.get(ch));
      }
    }
  }

  public static void main(String a[]){
    DuplicateCharsInString dcs = new DuplicateCharsInString();
    dcs.findDuplicateChars("Java2Novice");
  }
}
