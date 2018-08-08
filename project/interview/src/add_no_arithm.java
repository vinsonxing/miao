/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-28
 * Time: 下午5:09
 * To change this template use File | Settings | File Templates.
 */
public class add_no_arithm {
  public static int add(int a, int b) {
    int temp = a ^ b;
    System.out.println("temp="+temp);
    return temp;
  }
  public static void main(String[] args){
    add(29, 45);
  }
}
