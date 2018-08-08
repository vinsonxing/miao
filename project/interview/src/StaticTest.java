/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/15/14
 * Time: 10:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaticTest {


  static
  {
    System.out.println(StaticTest.string+" "+StaticTest.integer);
  }
  final static String string="static";
  final static Integer integer=1;


  public static void main(String [] args)//throws Exception
  {
  }
}
