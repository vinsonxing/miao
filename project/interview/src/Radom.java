/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/6/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Radom {
  int a = 10;
  static void pass (int x) {
    x++;
  }
  static void pass (test x) {
    x.addT();
  }


  public static void main(String[] args){
    int b = 9;
    test tt = new test();
    tt.setT(99);
    pass(tt);
    System.out.println("tt is " + tt.getT());
  }
}
class test {
  int t;

  int getT() {
    return t;
  }

  void setT(int t) {
    this.t = t;
  }

  void addT(){
    this.t++;
  }
}
