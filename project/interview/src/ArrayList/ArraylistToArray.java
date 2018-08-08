package ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-12-4
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
public class ArraylistToArray {
  public static void main(String[] args){
    ArrayList assetTradingList = new ArrayList();

    assetTradingList.add("Stocks trading");
    assetTradingList.add("futures and option trading");
    assetTradingList.add("electronic trading");
    assetTradingList.add("forex trading");
    assetTradingList.add("gold trading");
    assetTradingList.add("fixed income bond trading");
    String [] assetTradingArray = new String[assetTradingList.size()];
    assetTradingList.toArray(assetTradingArray);

  }
}
