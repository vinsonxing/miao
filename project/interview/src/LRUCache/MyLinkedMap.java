package LRUCache;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-9
 * Time: 下午6:24
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MyLinkedMap<K, V> extends LinkedHashMap<K, V> {
  public MyLinkedMap(boolean accessOrder) {
    super(16, 0.75f, accessOrder);
  }

  /**
   * 队列最大容量，超过此容量时，会将最“旧”数据删除掉
   */
  private static final int MAX_ENTRIES = 5;

  /**
   * 重写父类方法，实现LRU算法
   */
  protected boolean removeEldestEntry(Map.Entry eldest) {
    return size() > MAX_ENTRIES;
  }

  public static void main(String[] args) {

    MyLinkedMap<Integer, Integer> map = new MyLinkedMap<Integer, Integer>(true);

    map.put(1, 0);
    map.put(2, 0);
    map.put(3, 0);
    map.put(4, 0);
    map.put(5, 0);

    map.get(2);
    map.get(4);

    for (Entry<Integer, Integer> e : map.entrySet()) {
      System.out.println(e.getKey());
    }

  }
}
