package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-13
 * Time: 下午1:33
 * To change this template use File | Settings | File Templates.
 */
public class StockBuyAndSell {
  public static int maxProfit(int[] prices) {
    int len = prices.length;
    if (len == 0 || len == 1) return 0;
    int[] maxLeft = new int[len], maxRight = new int[len];
    int low = prices[0], high = prices[len-1];
    maxLeft[0] = 0;
    maxRight[len-1] = 0;

    int max = Integer.MIN_VALUE;
    for (int i = 1; i < len; i++) {
      low = Math.min(low, prices[i]);
      max = Math.max(max, prices[i] - low);
      maxLeft[i] = max;
      System.out.print(maxLeft[i] +" ");
    }
    System.out.println();
    max = Integer.MIN_VALUE;
    for (int i = len - 2; i>=0; i--) {
      high = Math.max(high, prices[i]);
      max = Math.max(max, high - prices[i]);
      maxRight[i] = max;
      System.out.print(maxRight[i] +" ");
    }
    System.out.println();
    max = Integer.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      max = Math.max(max, maxLeft[i] + maxRight[i]);
    }
    return max;
  }
  public static void main(String[] args){
    int[] prices = new int[] {3, 5, 4, 2, 9, 1, 7};
    int res = maxProfit(prices);
    System.out.println("result is "+res);
  }
}
