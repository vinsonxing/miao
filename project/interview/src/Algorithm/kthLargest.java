package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class kthLargest {
  public static void main(String[] args){
    int[] list = {1, 4, 2, 6, 5};
    System.out.println("it is " + kthLargest(list, 3));
  }
  static int kthLargest(int[] list, int k) {
    int left = 0;
    int right = list.length-1;
    while(true) {
      int pivIndex = (left+right)/2;
      int newPiv = partition(list, left, right, pivIndex);
      if(newPiv == k)
        return list[newPiv];
      else if(newPiv < k) {
        left = newPiv+1;
      }
      else {
        right = newPiv-1;
      }
    }
  }
  private static int partition(int[] list, int left, int right, int pivot) {
    int pivValue = list[pivot];
    swap(list, pivot, right);   //put pivot value on the end
    int storePos = left;
    for(int i=left; i<right; i++) {
      if(list[i] > pivValue) {
        swap(list, i, storePos);
        storePos++;
      }
    }
    swap(list, storePos, right);
    return storePos;
  }

  private static void swap(int[] list, int a, int b) {
    int temp = list[a];
    list[a] = list[b];
    list[b] = temp;
  }
}
