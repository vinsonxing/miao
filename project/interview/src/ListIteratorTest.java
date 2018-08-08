/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-5
 * Time: 下午4:17
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public class ListIteratorTest {
  public static void main(String args []){
    List<String> list= new ArrayList<String>();
    list.add("hi");
    list.add("whats up");
    list.add("how are you");
    list.add("bye");

    ListIterator<String> iterator = list.listIterator();
    int i=0;
    while(iterator.hasNext()){
      String s = iterator.next();
      iterator.add(""+i++);

    }

    System.out.println(list);
    //output: [hi, 0, whats up, 1, how are you, 2, bye, 3]

  }
}
