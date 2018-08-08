package CrackingCodeInterview.Chapter2;

import CrackingCodeInterview.CtCILibrary.LinkedListNode;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/28/14
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class3 {
  public static void deleteNode(LinkedListNode n)
  {
    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;
  }
  public static void main(String[] args)
  {

  }

}
