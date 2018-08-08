/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 12/10/14
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
class ThreadA extends Thread{

  private Thread thdOther;

  ThreadA(Thread thdOther){
    this.thdOther = thdOther;
  }

  public void run(){

    System.out.println(getName() + " 运行...");

    int sleepTime = (int)(Math.random() * 10000);
    System.out.println(getName() + " 睡眠 " + sleepTime
            + " 毫秒。");

    try{
      Thread.sleep(sleepTime);
    }catch(InterruptedException e){}

    System.out.println(getName() + " 觉醒，即将中断线程 B。");
    // 中断线程B,线程Ｂ暂停运行
    thdOther.interrupt();
  }
}
class ThreadB extends Thread{
  int count = 0;

  public void run(){

    System.out.println(getName() + " 运行...");

    while (!this.isInterrupted()){
      System.out.println(getName() + " 运行中 " + count++);

      try{
        Thread.sleep(10);
      }catch(InterruptedException e){
        int sleepTime = (int)(Math.random() * 10000);
        System.out.println(getName() + " 睡眠" + sleepTime
                + " 毫秒。觉醒后立即运行直到终止。");

        try{
          Thread.sleep(sleepTime);
        }catch(InterruptedException m){}

        System.out.println(getName() + " 已经觉醒，运行终止...");
        // 重新设置标记，继续运行
        this.interrupt();
      }
    }

    System.out.println(getName() + " 终止。");
  }
}
public class InteruptTest {
  public static void main(String argv[]){
    ThreadB thdb = new ThreadB();
    thdb.setName("ThreadB");

    ThreadA thda = new ThreadA(thdb);
    thda.setName("ThreadA");

    thdb.start();
    thda.start();
  }
}
