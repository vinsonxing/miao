/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 11/5/14
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
  public static void main(String [] args){
    ExecutorService service=Executors.newCachedThreadPool();
    final CyclicBarrier cb=new CyclicBarrier(3);  //三个线程同时到达
    for(int i=0;i<3;i++){
      Runnable runnable=new Runnable(){
        public void run(){
          try {
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("Thread"+Thread.currentThread().getName()+
                    " will arrive at location 1，there have already been "+(cb.getNumberWaiting()+1)+" arrived"+
                    (cb.getNumberWaiting()==2?" All there，keep going":" waiting"));
            try {
              cb.await();
            } catch (BrokenBarrierException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("Thread"+Thread.currentThread().getName()+
                    " will arrive at location 2，there have already been "+(cb.getNumberWaiting()+1)+" arrived"+
                    (cb.getNumberWaiting()==2?" All here，keep going":" waiting"));
            try {
              cb.await();
            } catch (BrokenBarrierException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            Thread.sleep((long)(Math.random()*10000));
            System.out.println("Thread"+Thread.currentThread().getName()+
                    " will arrive at location 3，there have already been "+(cb.getNumberWaiting()+1)+" arrived"+
                    (cb.getNumberWaiting()==2?" All there，keep going":" waiting"));
            try {
              cb.await();
            } catch (BrokenBarrierException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      };
      service.execute(runnable);
    }
    service.shutdown();
  }
}
