/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/3/14
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringJoin {
  public static <T> String join(T[] array, String cement) {
    StringBuilder builder = new StringBuilder();

    if(array == null || array.length == 0) {
      return null;
    }

    for (T t : array) {
      builder.append(t).append(cement);
    }

    builder.delete(builder.length() - cement.length(), builder.length());

    return builder.toString();
  }
  public static void main(String[] args) {
    String[] test = new String[] {"you", "are", "didi"};
    System.out.println(join(test, ""));
  }
}
