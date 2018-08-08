/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-9
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */
public class PrintBinary {
  public static void printBinary(int n) {
//    for (int i = 1; i <= n; i++) {
//      doPrintBinary(i);
//      System.out.println();
//    }
    doPrintBinary(6);
  }
  public static void doPrintBinary(int n) {
    if (n > 1) {
      doPrintBinary(n >> 1);
    }
    System.out.print(n & 1);
  }
  public static void main(String[] args){
    printBinary(7);
  }
}
