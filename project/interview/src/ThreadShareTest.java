/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 12/10/14
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
class ShareData{
  public static String szData = "";
}
class ThreadDemo extends Thread{

  private ShareData oShare;

  ThreadDemo(){
  }

  ThreadDemo(String szName,ShareData oShare){
    super(szName);
    this.oShare = oShare;
  }

  public void run() {
    // 为了更清楚地看到不正确的结果，这里放一个大的循环
    for (int i = 0; i < 50; i++){
      if (this.getName().equals("Thread1")) {
        synchronized (oShare){
          oShare.szData = "这是第 1 个线程";
        // 为了演示产生的问题，这里设置一次睡眠
         try{
          Thread.sleep((int)Math.random() * 100); }
          catch(InterruptedException e){
          }
         System.out.println(this.getName() + ":" + oShare.szData);
        }
          // 输出结果
          //System.out.println(this.getName() + ":" + oShare.szData);
         
        }else if (this.getName().equals("Thread2")){
        synchronized (oShare){
          oShare.szData = "这是第 2 个线程";
          // 为了演示产生的问题，这里设置一次睡眠
           try{
            Thread.sleep((int)Math.random() * 100); }
            catch(InterruptedException e){
            }
           System.out.println(this.getName() + ":" + oShare.szData);
          }
            // 输出结果
           //System.out.println(this.getName() + ":" + oShare.szData);
          }
        }
      }
}
  public class ThreadShareTest {
    public static void main(String argv[]){
      ShareData oShare = new ShareData();
      ThreadDemo th1 = new ThreadDemo("Thread1",oShare);
      ThreadDemo th2 = new ThreadDemo("Thread2",oShare);

      th1.start();
      th2.start();
    }
  }
