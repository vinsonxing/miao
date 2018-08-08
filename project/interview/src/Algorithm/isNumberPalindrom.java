package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/7/14
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class isNumberPalindrom {
  boolean isPalindrome(int x) {
    if(x<0) return false;
    int count = 1;
    int a =0, b=0;
    while(x/count>=10)
      count*=10;

    while(x>1){

      a = x/count;
      b = x%10;

      if(a!=b) return false;

      x = x-a*count;
      x = (x-b)/10;

      count/=100;//because x has cut two bits. so its 100.
    }
    return true;
  }
}
