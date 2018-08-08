package Algorithm;

import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/3/14
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */

// 7， 5， 6， 3， 4 ， 1， 2， 9， 11， ->  9， 6， 9, 4， 9， 2， 9， 11， 11
public class ReplaceWithBiggestFromRight {
  void replaceWithBiggestFromRight( int[] arr ){
    Deque<Integer> biggestRight = new ArrayDeque<Integer>();
    for(int i=arr.length-1; i>0; i--)
    {
      int temp = arr[i];
      while(!biggestRight.isEmpty() && biggestRight.peekFirst() <= arr[i])
      {
        biggestRight.pop();
      }
      if(!biggestRight.isEmpty())
      {
        arr[i] = biggestRight.peekFirst();
      }
      biggestRight.push(temp);
    }
  }
}
