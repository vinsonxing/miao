package Algorithm.BST;

import CrackingCodeInterview.CtCILibrary.*;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/10/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class maxPathSum {
  public static int maxPathSum(CrackingCodeInterview.CtCILibrary.TreeNode root){
    if(root == null)
    {
      return 0;
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    res.add(Integer.MIN_VALUE);
    helper(root, res);
    return res.get(0);
  }
  public static int helper(CrackingCodeInterview.CtCILibrary.TreeNode root, ArrayList<Integer> res){
    if(root == null){
      return 0;
    }
    int left = helper(root.left, res);
    int right = helper(root.right, res);
    int cur = root.data + (left>0 ? left:0) + (right>0?right:0);
    if(cur > res.get(0)){
      res.set(0,cur);
    }
    return root.data + Math.max(left, Math.max(right, 0));
  }
}
