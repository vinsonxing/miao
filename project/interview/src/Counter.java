/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 9/16/14
 * Time: 11:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Counter {
  public static int value = 0;
  public static synchronized void increase(){
    for(int i=0; i<1000; i++){
      value++;
      System.out.println("call static increase, value="+value);
    }
  }
  public synchronized void increase1() {
    for(int i=0; i<1000; i++){
      value++;
      System.out.println("call NON static increase, value="+value);
    }
  }
  public static void main(String[] args){
    Counter c = new Counter();
    testThread t1 = new testThread(c, true);
    testThread t2 = new testThread(c, false);
    t2.start();
    t1.start();
  }
}
class testThread extends Thread{
  Counter counter;
  boolean isStatic;
  testThread(Counter c, boolean s){
    this.counter = c;
    this.isStatic = s;
  }
  public void run(){
    if(isStatic) {
      Counter.increase();
    }
    else {
      counter.increase1();
    }
  }
}
