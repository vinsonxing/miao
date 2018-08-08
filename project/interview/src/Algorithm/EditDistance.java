package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/4/14
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
//http://www.programcreek.com/2013/12/edit-distance-in-java/
public class EditDistance {
  public static int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();

    // len1+1, len2+1, because finally return dp[len1][len2]
    int[][] dp = new int[len1 + 1][len2 + 1];

    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }

    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }

    //iterate though, and check last char
    for (int i = 0; i < len1; i++) {
      char c1 = word1.charAt(i);
      for (int j = 0; j < len2; j++) {
        char c2 = word2.charAt(j);

        //if last two chars equal
        if (c1 == c2) {
          //update dp value for +1 length
          dp[i + 1][j + 1] = dp[i][j];
        } else {
          int replace = dp[i][j] + 1;
          int insert = dp[i][j + 1] + 1;
          int delete = dp[i + 1][j] + 1;

          int min = replace > insert ? insert : replace;
          min = delete > min ? min : delete;
          dp[i + 1][j + 1] = min;
        }
        System.out.print("[" + i + "][" + j + "]" +dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("we are returning dp" + "[" + len1 + "][" + len2 + "]");
    return dp[len1][len2];
  }

  public static void main(String[] args)
  {
    String s1 = "hello";
    String s2 = "ello";
    System.out.println("It is " + minDistance(s1, s2));
  }
}
