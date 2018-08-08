/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/14/14
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderTest {
  public static OrderTest m = new OrderTest();

  public   OrderTest(){
    System.out.printf("MAIN CONSTRUCTOR\n");
  }

  {
    System.out.printf("NON-STATIC BLOCK\n");
  }

  static{
    System.out.printf("STATIC BLOCK\n");
  }

  //public static OrderTest m = new OrderTest();



  public static void main(String... args) {
//    OrderTest m = new OrderTest();
    System.out.printf("MAIN METHOD\n");

  }
}
