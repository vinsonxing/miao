package Algorithm;
import java.util.List;
import java.util.ArrayList;

public class CountWaysRecursive {
  List<Integer> result = new ArrayList<Integer>();
  public static int countWaysRecursive(int n) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {

      return 1;
    } else {
      return countWaysRecursive(n - 1) + countWaysRecursive(n - 2) + countWaysRecursive(n - 3);
    }
  }
  public static void main(String[] args)
  {
    System.out.println(countWaysRecursive(5));
  }
}
