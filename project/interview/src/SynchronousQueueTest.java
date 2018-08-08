/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 11/6/14
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.concurrent.SynchronousQueue;

class testObj{
  public testObj(int str){
    id = str;
  }
  public int id;
}

public class SynchronousQueueTest {
  public static void main(String[] args) throws Exception{
    SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
    for(int i=0;i<1;i++){
      Thread t = new SQThread(queue, 1);
      t.start();
    }
//    Thread.sleep(100);
    for(int i=0;i<10;i++){
      testObj test = new testObj(i);
      if(!queue.offer(test)){
        System.out.println(test.id + "--Failure");
      }
    }
  }
  public static class SQThread extends Thread{
    private SynchronousQueue<Object> queue;
    int mode;
    SQThread(SynchronousQueue<Object> queue,int mode){
      this.queue = queue;
      this.mode = mode;
    }
    @Override
    public void run(){
      Object item = null;
      try{
        System.out.println("thread id:"+Thread.currentThread().getId());
        if(mode == 1){
//          Thread.sleep(1000);
          while((item = queue.take()) != null){
            System.out.println(((testObj)item).id + "--success");
          }
        }else{
          //
        }
      }catch(Exception e){
        System.out.println("exception");
      }
      System.out.println("end");
    }
  }
}
