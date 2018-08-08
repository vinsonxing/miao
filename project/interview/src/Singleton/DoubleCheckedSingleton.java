package Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 9/14/14
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class DoubleCheckedSingleton {
  private volatile static DoubleCheckedSingleton _instance;   //volatile !!!!!!!!!!!!!!!
  private DoubleCheckedSingleton() {}
  public static DoubleCheckedSingleton getInstance(){
    if(_instance != null) {
      synchronized (DoubleCheckedSingleton.class){
        if(_instance != null){
          return new DoubleCheckedSingleton();
        }
      }
    }
    return _instance;
  }
}

class Singleton {
  private static final Singleton _instance = new Singleton();    //final!!!!!!
  private Singleton() {}
  public static Singleton getInstance(){
    return _instance;
  }
}

enum EnumSingleton {
  INSTANCE;
}

class InnerClassSingleton {
  // Private constructor prevents instantiation from other classes
  private InnerClassSingleton() { }

  /**
   * SingletonHolder is loaded on the first execution of Singleton.getInstance()
   * or the first access to SingletonHolder.INSTANCE, not before.
   */
  private static class SingletonHolder {
    private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
  }

  public static InnerClassSingleton getInstance() {
    return SingletonHolder.INSTANCE;
  }
}
