package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-22
 * Time: 下午9:28
 * To change this template use File | Settings | File Templates.
 */
public class findLongestRepeatingChar {
  public static Character findLongestRepeatingChar(String s) {

    if (s == null || s.length() == 0 || s.equals("")) {
      System.out.println("Error, invalid input String!");
      return null;
    }

    char[] chars = s.toCharArray();
    char maxChar = chars[0];
    char curChar = chars[0];
    int count = 1;
    int maxCount = 0;
    int sLen = s.length();

    for (int i = 1; i < sLen && (sLen - i > maxCount); i++) {
      if (chars[i] == curChar) {
        count++;
      } else {
        if (count > maxCount) {
          maxCount = count;
          maxChar = curChar;
        }
        count = 1;
        curChar = chars[i];
      }
    }
    return new Character(maxChar);
  }

  public static void main(String[] args) {
    String test = "aabbbcccdddeeefffgggghhhjjjiiklllmmnnopqrstuvxz";
    System.out.println(findLongestRepeatingChar(test));
  }
}
