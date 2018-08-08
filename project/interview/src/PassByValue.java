/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-6
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
public class PassByValue {
  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("Hello ");
    System.out.println("Before change, sb = " + sb);
    changeData(sb);
    System.out.println("After changeData(n), sb = " + sb);
  }

  public static void changeData(StringBuffer strBuf) {
    StringBuffer sb2 = new StringBuffer("Hi ");
    strBuf = sb2;
    sb2.append("World!");
  }
}
