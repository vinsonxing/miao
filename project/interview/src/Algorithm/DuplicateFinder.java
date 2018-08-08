package Algorithm;

import java.util.Set;
import java.util.HashSet;
import java.util.BitSet;

public class DuplicateFinder {
  boolean duplicates(final int[] zipcodelist)
  {
    Set<Integer> lump = new HashSet<Integer>();
    for (int i : zipcodelist)
    {
      if (lump.contains(i)) return true;
      lump.add(i);
    }
    return false;
  }

//  boolean betterPerformanceDuplicats(int[] zipcodeList)
//  {
//    java.util.Arrays.fill(bitmap, false);
//    for (int item : zipcodeList)
//      if (!bitmap[item]) bitmap[item] = true;
//      else {
//        duplicate = true;
//        break;
//      }
//  }
}
