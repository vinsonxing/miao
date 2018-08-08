/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-25
 * Time: 下午3:48
 * To change this template use File | Settings | File Templates.
 */
public class AnonymousClass {
  int a = 4;
  public Wrapping wrap(final int x) {
    final int b = 7;
// Base constructor call:
    return new Wrapping(x, b) { // Pass constructor argument.
      public int value() {
        int temp = AnonymousClass.this.a + b;
        return temp;
      }
    }; // Semicolon required
  }
  public static void main(String[] args) {
    AnonymousClass p = new AnonymousClass();
    Wrapping w = p.wrap(10);
    System.out.println("value is " + w.value());
  }
}
abstract class Wrapping{
  Wrapping(int x, int y){}
//  int value = 2;
  abstract int value();
}
