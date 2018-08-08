/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 10/13/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Outer {
  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
    inner.print("Outer.new");

    inner = outer.getInner();
    inner.print("Outer.get");
  }

  public void test(){
//    Inner inner = new Inner();
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
  }

  // 个人推荐使用getxxx()来获取成员内部类，尤其是该内部类的构造函数无参数时
  public Inner getInner() {
    return new Inner();
  }

  public class Inner {
    public void print(String str) {
      System.out.println(str);
    }
  }
}
