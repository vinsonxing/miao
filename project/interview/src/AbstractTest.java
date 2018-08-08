/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/14/14
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractTest {
  public static void main(final String... args) {
    final Printer p = new Printer() {
      public void printSomethingOther() {
        System.out.println("other");
      }
      @Override
      public void print() {
        super.print();
        System.out.println("world");
        printSomethingOther(); // works fine
      }
    };
    p.print();
    //p.printSomethingOther(); // does not work
  }
}

abstract class Printer {
  public void print() {
    System.out.println("hello");
  }
}