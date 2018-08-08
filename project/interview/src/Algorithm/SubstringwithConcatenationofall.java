package Algorithm;


import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/6/14
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubstringwithConcatenationofall {
  public ArrayList<Integer> findSubstring(String S, String[] L) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if(S==null || S.length()==0 || L==null || L.length==0)
      return res;
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    for(int i=0;i<L.length;i++)
    {
      if(map.containsKey(L[i]))
      {
        map.put(L[i],map.get(L[i])+1);
      }
      else
      {
        map.put(L[i],1);
      }
    }
    for(int i=0;i<L[0].length();i++)
    {
      HashMap<String,Integer> curMap = new HashMap<String,Integer>();
      int count = 0;
      int left = i;
      for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())
      {
        String str = S.substring(j,j+L[0].length());

        if(map.containsKey(str))
        {
          if(curMap.containsKey(str))
            curMap.put(str,curMap.get(str)+1);
          else
            curMap.put(str,1);
          if(curMap.get(str)<=map.get(str))
            count++;
          else
          {
            while(curMap.get(str)>map.get(str))
            {
              String temp = S.substring(left,left+L[0].length());
              curMap.put(temp,curMap.get(temp)-1);
              if(curMap.get(temp)<map.get(temp))
                count--;
              left += L[0].length();
            }
          }
          if(count == L.length)
          {
            res.add(left);
            //if(left<)
            String temp = S.substring(left,left+L[0].length());
            curMap.put(temp,curMap.get(temp)-1);
            count--;
            left += L[0].length();
          }
        }
        else
        {
          curMap.clear();
          count = 0;
          left = j+L[0].length();
        }
      }
    }
    return res;
  }
}
