/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 6/15/14
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
  public static <T> T addAndReturn(T element, Collection<T> collection){
    collection.add(element);
    System.out.println(element + " is added successfully" );
    return element;
  }

  public static void main(String... args){
    String stringElement = "stringElement";
    List<Object> objectList = new ArrayList<Object>();
    Object theElement = addAndReturn(stringElement, objectList);

//    ArrayList<Number> ints2 = new ArrayList<Integer>();
    List<? extends Number> ints = new ArrayList<Integer>();
//    ints.add(new Integer(1));
    List<Number> nums = new ArrayList<Number>();
    List<Integer> ints1 = Arrays.asList(1, 2);
    List<Double> dbls = Arrays.asList(2.78, 3.14);
    nums.addAll(ints1);
    nums.addAll(dbls);

//    ints.addAll(ints1);
  }
  
//  public void testWildCard(Collection<?> collection) {
//	  collection.add(123);
//	  collection.add(new Object());
//  }
}
