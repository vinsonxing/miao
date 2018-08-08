/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/15/14
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */

/*
So what are the advantages of static blocks?
If you’re loading drivers and other items into the namespace. For ex, Class class has a static block where it registers the natives.
If you need to do computation in order to initialize your static variables,you can declare a static block which gets executed exactly once,when the class is first loaded.
Security related issues or logging related tasks
 */
public class ConstructorBlockExample{

  {
    System.out.println("This is first constructor block");
  }

  public ConstructorBlockExample(){
    System.out.println("This is no parameter constructor");
  }

  public ConstructorBlockExample(String param1){
    System.out.println("This is single parameter constructor");
  }

  public ConstructorBlockExample(String param1, String param2){
    System.out.println("This is two parameters constructor");
  }

  {
    System.out.println("This is second constructor block");
  }

  public static void main(String[] args){
    ConstructorBlockExample constrBlockEx =
            new ConstructorBlockExample();
    ConstructorBlockExample constrBlockEx1 =
            new ConstructorBlockExample("param1");
    ConstructorBlockExample constrBlockEx2 =
            new ConstructorBlockExample("param1", "param2");
  }
}