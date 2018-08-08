import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/14/14
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */

public class InheritTest {
  void print() throws java.io.IOException{
    System.out.println("parent");
  }
  public static void main(String[] args)  {

//    subClass sub = new subClass();
//    int a = sub.i;
////    sub.special();
////    sub.print();
//    test(new InheritTest());
//    test(new subClass());
    try{
      InheritTest t = (InheritTest)new subClass();
      t.print();
    }catch (Exception e){}
  }

  private static void test(InheritTest it) {
    try {
      it.print();
    } catch (IOException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }
}

 class subClass extends InheritTest {
   protected int i;
   @Override
   void print() {
     System.out.println("child - print");
   }
   void special() {
     System.out.println("child");
   }
 }
