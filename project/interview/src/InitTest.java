/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/15/14
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
class Super {
  Super() { printThree(); }
  void printThree() { System.out.println("three"); }
}
public class InitTest extends Super {
  int three = (int)Math.PI;  // That is, 3
  void printThree() { System.out.println(three); }

  public static void main(String[] args) {
    InitTest t = new InitTest();
    t.printThree();
  }
}
