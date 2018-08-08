import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/1/14
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapTest {

  public static void main(String[] args) {
    Map<String, valueType> m = new HashMap<String, valueType>();
    valueType v1 = new valueType("hello");
    valueType v2 = new valueType("didi");
    m.put("k1", v1);
    m.put("k2", v2);
    valueType tmp = m.get("k1");
    tmp.setValue("time");
    System.out.println(m.get("k1").getValue());
  }
}

class valueType
{
  String value;

  public valueType(String value){
    this.value = value;
  }

  String getValue() {
    return value;
  }

  void setValue(String value) {
    this.value = value;
  }
}
