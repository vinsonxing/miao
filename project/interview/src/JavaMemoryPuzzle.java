/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/1/14
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class JavaMemoryPuzzle {
  private final int dataSize =
          (int) (Runtime.getRuntime().maxMemory() * 0.6);

  public void f() {
    {
      byte[] data = new byte[dataSize];
    }

//    for(int i=0; i<10; i++) {
//      System.out.println("Please be so kind and release memory");
//    }

    byte[] data2 = new byte[dataSize];
    int i = 0;
    System.out.println("used memory=>" +  (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    System.out.println("max memory=>" + Runtime.getRuntime().maxMemory());
    System.out.println("total memory=>" + Runtime.getRuntime().totalMemory());
//    System.out.println(data2.length);
  }

  public static void main(String[] args) {
    JavaMemoryPuzzle jmp = new JavaMemoryPuzzle();
//    try {
      jmp.f();
//    } catch (Throwable e) {
//      System.out.println("Out of memory");
//    }

    System.out.println("No OutOfMemoryError");
  }
}
