package CrackingCodeInterview.Chapter2;

import CrackingCodeInterview.CtCILibrary.LinkedListNode;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/28/14
 * Time: 11:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class4 {
  public static LinkedListNode partition(LinkedListNode node, int x)
  {
    LinkedListNode beforeStart = null;
    LinkedListNode beforeEnd = null;
    LinkedListNode afterStart = null;
    LinkedListNode afterEnd = null;
    while(node != null)
    {
      LinkedListNode next = node.next;
      node.next = null;
      if(node.data < x)
      {
        if(beforeStart == null)
        {
          beforeStart = node;
          beforeEnd = beforeStart;
        }
        else
        {
          beforeEnd.next = node;
          beforeEnd = node;
        }
      }
      else if(node.data > x)
      {
        if(afterStart == null)
        {
          afterStart = node;
          afterEnd = afterStart;
        }
        else
        {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = node.next;
    }
    if(beforeStart == null)
    {
      return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
  }
}
