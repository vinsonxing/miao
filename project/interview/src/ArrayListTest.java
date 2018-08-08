/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-9
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class ArrayListTest {
  public static void main(String[] args){
    List<String> list = new ArrayList<String>();
    list.add("how");
    list.add("are");
    list.add("you");
//    for(String item : list){
//      list.add(item);
//    }
    Iterator<String> it = list.iterator();
    while(it.hasNext()){
      String val = it.next();
      if("you".equals(val)) {
        it.remove();
      }
    }
    for(String item : list){
      System.out.println("--"+item);
    }
  }
}
