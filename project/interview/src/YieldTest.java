/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/23/14
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class YieldTest implements Runnable{
  public static void main(String[] args) throws Exception{
    Thread t = new Thread(new YieldTest());
    t.start();

    for(int i=0; i<5; i++) {
      Thread.sleep(1000);
      System.out.println("Inside main");
    }
  }

  public void run() {
    for(int i=0; i<5; i++) {
      Thread.yield();
      System.out.println("Inside run" + i);
    }
  }
}
