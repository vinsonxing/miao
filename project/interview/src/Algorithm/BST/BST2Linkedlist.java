package Algorithm.BST;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/5/14
 * Time: 6:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class BST2Linkedlist {
  public static TreeNode flatten(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode p = root;

    while(p != null || !stack.empty()){

      if(p.right != null){
        stack.push(p.right);
      }

      if(p.left != null){
        p.right = p.left;
        p.left = null;
      }else if(!stack.empty()){
        TreeNode temp = stack.pop();
        p.right=temp;
      }

      p = p.right;
    }
    return root;
  }
  public static void main(String[] args){
    TreeNode root = new TreeNode(4);
    TreeNode left = new TreeNode(3);
    TreeNode right = new TreeNode(5);
    root.left = left;
    root.right = right;
    TreeNode p = flatten(root);
    //System.out.println(p.val);
    while(p.right != null){
       System.out.println(p.right.val);
    }
  }
}
