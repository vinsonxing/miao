/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-9
 * Time: 上午12:07
 * To change this template use File | Settings | File Templates.
 */
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest {
  public static void main(String[] args)
  {
    try {
      String[] arr = new String[]{"how", "are","you"};
      final CopyOnWriteArrayList list = new CopyOnWriteArrayList(arr);
      Iterator<String> it = list.iterator();
      Runnable runnable=new Runnable(){
        public void run(){
          Iterator<String> it = list.iterator();
          while(it.hasNext()){
            String str = it.next();
            String tem = str + "...";
            list.add(tem);
          }
        }
      };
      new Thread(runnable).start();
      Thread.sleep(1);
      it = list.iterator();
      while(it.hasNext()){
        String str = it.next();
        System.out.println("str is " + str);
      }
      for(Object str:list.toArray()) {
    	  System.out.println("str is " + (String)str);
      }
    } catch (Exception e){}
  }
}
