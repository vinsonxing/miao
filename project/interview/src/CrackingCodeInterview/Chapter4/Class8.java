package CrackingCodeInterview.Chapter4;
import CrackingCodeInterview.CtCILibrary.*;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/6/14
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class8 {
  public static boolean matchTree(TreeNode t1, TreeNode t2)
  {
    if(t1 == null && t2 == null){
      return true;
    }
    if(t1 == null || t2 == null){
      return false;
    }
    if(t1.data != t2.data){
      return false;
    }
    return(matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
  }

  public static boolean subTree(TreeNode t1, TreeNode t2){
    if(t1 == null){
      return false;
    }
    if(t1.data == t2.data){
      return matchTree(t1, t2);
    }
    return (matchTree(t1.left, t2) || matchTree(t1.right, t2));
  }

  public static boolean containsTree(TreeNode t1, TreeNode t2){
    if(t2 == null){
      return true;
    }
    return subTree(t1, t2);
  }
}
