package HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/1/14
 * Time: 12:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnEntry<K, V> {
  private AnEntry<K, V> next;
  private final K key;
  private V value;

  public AnEntry(K key, V value) {
    this.key = key;
    this.setValue(value);
  }

  public K getKey() {
    return key;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public V getValue() {
    return value;
  }

  public void setNext(AnEntry<K, V> next) {
    this.next = next;
  }

  public AnEntry<K, V> getNext() {
    return next;
  }
}
