/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-27
 * Time: 下午3:05
 * To change this template use File | Settings | File Templates.
 */
import java.lang.ref.*;
import java.util.*;

public class WeakReferenceTest {
  public static void strongReference() {
    Object referent = new Object();

    /**
     * 通过赋值创建 StrongReference
     */
    Object strongReference = referent;


    referent = null;
    System.gc();

    /**
     * StrongReference 在 GC 后不会被回收
     */
    if(strongReference == null) {
      System.out.println("GC of strong reference is successful");
    } else {
      System.out.println("GC of strong reference is not done");
    }
  }
  public static void weakReference() throws InterruptedException{
    Object referent = new Object();
    WeakReference<Object> weakRerference = new WeakReference<Object>(referent);
    referent = null;
    System.gc();
    Thread.sleep(1000);
    if(weakRerference.get() == null) {
      System.out.println("GC of weak reference is successful");
    } else {
      System.out.println("GC of weak reference is not done");
    }
  }

  public static void weakHashMap() throws InterruptedException {
    Map<Object, Object> weakHashMap = new WeakHashMap<Object, Object>();
    Object key = new Object();
    Object value = new Object();
    weakHashMap.put(key, value);

    if(weakHashMap.containsValue(value)) {
      System.out.println("map has value");
    }

    key = null;
    System.gc();

    /**
     * 等待无效 entries 进入 ReferenceQueue 以便下一次调用 getTable 时被清理
     */
    Thread.sleep(1000);

    /**
     * 一旦没有指向 key 的强引用, WeakHashMap 在 GC 后将自动删除相关的 entry
     */
    if(!weakHashMap.containsKey(key) && !weakHashMap.containsValue(value)){
      System.out.println("Doesn't contain value");
    }
  }
  public static void main(String[] args) {
    try{
//    strongReference();
//    weakReference();
      weakHashMap();
    } catch(Exception ex){

    }
  }
}
