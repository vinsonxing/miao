package Algorithm.BST;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/2/14
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch {
  static int getIndex(int[] array, int number, int lower, int upper) {
    int range, center;
    range = upper-lower;
    center = range/2 + lower;
    if(number == array[center]){
      return center;
    }
    else if(number > array[center]) {
      return getIndex(array, number, center+1, upper);
    }
    else
      return getIndex(array, number, lower, center-1);
  }
  public static void main(String[] args)
  {
    int[] array = new int[]{1, 3, 4, 5, 7, 11, 14, 19};
    System.out.println(getIndex(array, 19, 0, array.length));
  }
}
