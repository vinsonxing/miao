
package CrackingCodeInterview.Chapter4;

import CrackingCodeInterview.CtCILibrary.TreeNode;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/6/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class6 {
  static boolean isRight(TreeNode current){
    if(current.parent != null) {
      return current.parent.right == current;
    }
    return false;
  }
  static TreeNode findNext(TreeNode current){
    if(current.right != null){
      return findFirst(current.right);
    } else {
      while(isRight(current)){
        current = current.parent;
      }
      return current.parent;
    }
  }

  static TreeNode findFirst(TreeNode current){
    if(current.left == null){
      return current;
    } else {
      return findFirst(current.left);
    }
  }
  public static void main(String[] args)
  {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    for (int i = 0; i < array.length; i++) {
      TreeNode node = root.find(array[i]);
      TreeNode next = findNext(node);
      if (next != null) {
        System.out.println(node.data + "->" + next.data);
      } else {
        System.out.println(node.data + "->" + null);
      }
    }
  }
}
