

/*
http://javarevisited.blogspot.com/2012/07/when-class-loading-initialization-java-example.html
A class or interface type T will be initialized immediately before the first occurrence of any one of the following:

T is a class and an instance of T is created.

T is a class and a static method declared by T is invoked.

A static field declared by T is assigned.

A static field declared by T is used and the field is not a constant variable (搂4.12.4).

T is a top level class (搂7.6), and an assert statement (搂14.10) lexically nested within T (搂8.1.3) is executed.

A reference to a static field (搂8.3.1.1) causes initialization of only the class or interface that actually declares it, even though it might be referred to through the name of a subclass, a subinterface, or a class that implements an interface.

Invocation of certain reflective methods in class Class and in package java.lang.reflect also causes class or interface initialization.

A class or interface will not be initialized under any other circumstance.
 */

/*
  1. 常量池常量： public static <b>final</b> String/int/long.. value = "";
  2. 非常量池中的变量: 其他， 例如： public static <b>final</b>  Object value = new Object();  public static  Object value = new Object();
  当通过 Class.<变量>访问 以上两种变量时：
    访问 1， 不需要load 该变量所在文件 （class load时）， 则其中的static变量和块 都不会加载
    访问 2， 需要load变量所在文件，及父类文件，但父接口，不需要load。（同样适用于接口继承接口的情况）。
 */

public class InitOrderTest {
  public static final String preLoad = "BB";
  public static void main(String[] args) {

       System.out.println(SubClass1.test);
//    System.out.println(IClass.test);
  }
}

class Output {
  Object test;
  public static int out() {
      System.out.println("out");
     return 0;
  }
}
interface ISuper {
  int iSuper = Output.out();
}
interface IClass extends ISuper {
//  Object test = new Object();
//  static String test = "abc";
//  int test = 4;
  Integer test = Integer.valueOf(4);
  static int ii = Output.out();
}

class SuperClass implements IClass {

  public static String value1 = "LQ";
  static {
    System.out.println("super class init");
  }
}


class SubClass1 extends SuperClass {
//  public static String value1 = InitOrderTest.preLoad;
  public static String value = "BB";
//  public static final int value1 = 4;
  public static Integer i = new Integer(4);
  static {
    System.out.println("sub class init");
  }
}


