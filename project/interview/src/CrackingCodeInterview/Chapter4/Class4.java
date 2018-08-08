package CrackingCodeInterview.Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import CrackingCodeInterview.CtCILibrary.TreeNode;
import java.util.ArrayDeque;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/6/14
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class4 {
  static Stack<TreeNode> rootStack = new Stack<TreeNode>();
  static Stack<TreeNode> childStack = new Stack<TreeNode>();

  static List<LinkedList<TreeNode>> getLists(TreeNode root){
    List<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
    rootStack.push(root);
    while(!rootStack.isEmpty()){
      TreeNode node;
      LinkedList<TreeNode> list = new LinkedList<TreeNode>();
      while(!rootStack.isEmpty())
      {
        node= rootStack.pop();
        list.add(node);
        if(node.left != null){
          childStack.push(node.left);
        }
        if(node.right != null){
          childStack.push(node.right);
        }
      }
      res.add(list);
      rootStack = childStack;
      childStack = new Stack<TreeNode>();
    }
    return res;
  }

  public static void print(List<LinkedList<TreeNode>> res)
  {
    for(int i=0; i<res.size(); i++){
      List<TreeNode> list = res.get(i);
      for(TreeNode node:list){
        System.out.print(node.data+ " " );
      }
      System.out.println();
    }
  }
//  static List<LinkedList<TreeNode>> getLists1(TreeNode root){
//  }
  public static void main(String[] args){
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    TreeNode root = TreeNode.createMinimalBST(array);
    List<LinkedList<TreeNode>> res = getLists(root);
    print(res);
  }
}
