/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-9
 * Time: 下午2:16
 * To change this template use File | Settings | File Templates.
 */
class ParentTest {

  public int x = 0;

  public void print() {
    System.out.println("In Parent");
  }

}

public class ChildTest extends ParentTest {
  public int x = 1;

  public void print() {
    System.out.println("In Child");
  }

  public static void main( String args[] )
  {
    ParentTest s = new ChildTest();
    System.out.println(s.x);
    s.print();
  }
}