package Algorithm.BST;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/8/14
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class BSTnode {
  Comparable data;
  BSTnode left;
  BSTnode right;
  BSTnode(Comparable data)
  {
    this.data = data;
    this.left = null;
    this.right = null;
  }

  boolean add(Comparable value){
//    if(data.compareTo(value) == 0) {
//      return false;
//    }
    if(data.compareTo(value) > 0) {
      if(left == null){
        BSTnode left = new BSTnode(value);
        this.left = left;
        return true;
      } else {
        return left.add(value);
      }
    } else {
      if(right == null) {
        BSTnode right = new BSTnode(value);
        this.right = right;
        return true;
      } else {
        return right.add(value);
      }
    }
  }
}
