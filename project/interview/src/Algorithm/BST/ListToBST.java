package Algorithm.BST;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/5/14
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */

//  http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
public class ListToBST {
  //  Definition for singly-linked list.
  static ListNode h, n1, n2, n3, n4, n5, n6, n7;
  static {
  ListNode n1 = new ListNode(1);
  ListNode n2 = new ListNode(3);
  ListNode n3 = new ListNode(5);
  ListNode n4 = new ListNode(7);
  ListNode n5 = new ListNode(9);
  ListNode n6 = new ListNode(11);
  ListNode n7 = new ListNode(13);
//  ListNode n8 = new ListNode(15);
//  ListNode n9 = new ListNode(17);
  n1.next = n2;
  n2.next = n3;
  n3.next = n4;
  n4.next = n5;
  n5.next = n6;
  n6.next = n7;
//  n7.next = n8;
//  n8.next = n9;
  h = n1;
  }
    public static TreeNode sortedListToBST(ListNode head) {
      if (head == null)
        return null;

      h = head;
      int len = getLength(head);
      return sortedListToBST(0, len - 1);
    }

    // get list length
    public static int getLength(ListNode head) {
      int len = 0;
      ListNode p = head;

      while (p != null) {
        len++;
        p = p.next;
      }
      return len;
    }

    // build tree bottom-up
    public static TreeNode sortedListToBST(int start, int end) {
      if (start > end)
        return null;

      // mid
      int mid = (start + end) / 2;

      TreeNode left = sortedListToBST(start, mid - 1); //先递归还是先确定根结点
      TreeNode root = new TreeNode(h.val);
      root.left = left;
      h = h.next;
      TreeNode right = sortedListToBST(mid + 1, end);
      root.right = right;
      
      

      return root;
    }
  public static void main(String[] args){

    TreeNode root = sortedListToBST(h);
    System.out.println("root is" + root.val);

  }
}
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // Definition for binary tree
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

  }
