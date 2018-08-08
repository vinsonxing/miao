/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/22/14
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
import java.lang.reflect.Array;
public class FairLock {
//  Object a = String.class;
//  int[] intArray = (int[]) Array.newInstance(int.class, 3);
  {
    a = 1;
  }
   int a;
  public static void main(String[] args) throws ClassNotFoundException {
//    FairLock fl = new FairLock();
    Class cFl = Thread.currentThread().getContextClassLoader().loadClass("FairLock");
    cFl = Thread.currentThread().getContextClassLoader().loadClass("FairLock");
    System.out.println(cFl.getName());
  }
}
