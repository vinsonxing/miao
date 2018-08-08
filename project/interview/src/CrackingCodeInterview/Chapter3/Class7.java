package CrackingCodeInterview.Chapter3;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/3/14
 * Time: 6:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class7 {
//  public static void enqueue(){
//
//  }
//
//  public static Animal dequeueAny(){
//
//  }
//
//  public static Dog dequeueDog() {
//
//  }
//
//  public static Cat dequeueCat() {
//
//  }
}

interface Animal{
  public String getType();
}

class Cat implements Animal{
  public String getType(){
    return "cat";
  }
}

class Dog implements Animal{
  public String getType(){
    return "dog";
  }
}
