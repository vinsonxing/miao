package Algorithm;

import java.util.HashMap;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/5/14
 * Time: 1:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {
  public int[] twoSum(int[] numbers, int target) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] result = new int[2];

    for (int i = 0; i < numbers.length; i++) {
      if (map.containsKey(numbers[i])) {
        int index = map.get(numbers[i]);
        result[0] = index+1 ;
        result[1] = i+1;
        break;
      } else {
        map.put(target - numbers[i], i);
      }
    }

    return result;
  }
}
