package CrackingCodeInterview.Chapter4;

import CrackingCodeInterview.CtCILibrary.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/6/14
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class7 {
  public static boolean covers(TreeNode root, TreeNode p) {
    if (root == null) return false;
    if (root == p) return true;
    return covers(root.left, p) || covers(root.right, p);
  }
  public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    boolean is_p_on_left = covers(root.left, p);
    boolean is_q_on_left = covers(root.left,q);
    if(is_p_on_left != is_q_on_left) {
      return root;
    }
    TreeNode child_side = is_p_on_left ? root.left : root.right;
    return commonAncestorHelper(child_side, p, q);
  }
}
