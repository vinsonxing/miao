package HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/1/14
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleHashMap<K, V> {

  private int DEFAULT_BUCKET_COUNT = 128;

  private AnEntry<K, V>[] buckets;

  public SimpleHashMap() {
    buckets = new AnEntry[DEFAULT_BUCKET_COUNT];
  }

  public V get(K key) {
    throwIfKeyNull(key);

    AnEntry<K, V> entry = buckets[bucketIndexForKey(key)];
    while (entry != null && !key.equals(entry.getKey()))
      entry = entry.getNext();
    return entry != null ? entry.getValue() : null;
  }

  public void put(K key, V value) {
    throwIfKeyNull(key);

    int bucketIndex = bucketIndexForKey(key);
    AnEntry<K, V> entry = buckets[bucketIndex];

    if (null != entry) {
      boolean done = false;
      while(!done) {
        if (key.equals(entry.getKey())) {
          entry.setValue(value);
          done = true;
        } else if (entry.getNext() == null) {
          entry.setNext(new AnEntry<K, V>(key, value));
          done = true;
        }
        entry = entry.getNext();
      }
    } else {
      //nothing there at all; just shove the new entry in
      buckets[bucketIndex] = new AnEntry<K, V>(key, value);
    }
  }

  /**
   * THIS SHOULDN'T ACTUALLY BE PUBLIC; IT IS SO JUST FOR CLARIFICATION UNIT TEST PURPOSES
   *
   */
  public int bucketIndexForKey(K key) {
    int bucketIndex = key.hashCode() % buckets.length;
    return bucketIndex;
  }

  private void throwIfKeyNull(K key) {
    if (key == null) {
      throw new IllegalArgumentException("key may not be null");
    }
  }
}