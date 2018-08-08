/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/13/14
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */

//被final修饰，并且通过常量表达式初始化的变量，就是常量变量
public class StringTest {
  public static void main(String[] args) {

//      String s = 1 + "23";
//      System.out.println("answer is " + (s == "123"));
//
////      final String s2 = "a";
////      String s3 =s2 + "bc";
////      System.out.println("abc" == s3);
////    String s2 = "a";
////    System.out.println("result1:");
////    System.out.println("a" == s2);
//
//    String s1 = "ab";
//    String s4 = getA();
//    System.out.println("result2:");
//    System.out.println(s1==s4);
//
//    String s5 = new String("a");
//    String s6 = new String("b");
//    System.out.println("result3:");
//    System.out.println(s5 == s6);
      String a = "a";
      String b = "a";
      String c = new String("a");
      System.out.println("==== " + a.hashCode() + "==="+c.hashCode());
//      System.out.println(a.equals(c));
      System.out.println(a == c);
//      System.out.println((a+"b").equals(b+"b") );
  }
  public static String getA()
  {
    final String s1 = "a";  // without final, totally different
    String s2 = s1 + "b";
    System.out.println("result3:");
    System.out.println(s2 == "ab");
    return s2;
  }
}


