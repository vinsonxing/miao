package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/3/14
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */

// 海量数据 http://blog.csdn.net/v_july_v/article/details/6279498
 // http://www.cs.yale.edu/homes/aspnes/pinewiki/QuickSelect.html
public class TwoMaxNumbers {
  public void printTwoMaxNumbers(int[] nums){
    int MaxOne = 0;
    int MaxTwo = 0;
    for(int n:nums)
    {
      if(MaxOne < n){
        MaxTwo = MaxOne;
        MaxOne = n;
      } else if(MaxTwo < n)
      {
        MaxTwo = n;
      }
    }
  }
}
