package Algorithm.BST;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/10/14
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class main {
  static BSTnode n1, n2, n3, n4, n5, n6, n7;
  static BSTnode root;
  static{
    n1 = new BSTnode(1);
    n2 = new BSTnode(3);
    n3 = new BSTnode(5);
    n4 = new BSTnode(7);
    n5 = new BSTnode(9);
    n6 = new BSTnode(11);
    n7 = new BSTnode(13);
    BSTnode[] nodes = {n1, n2, n3, n4, n5, n6, n7};
    root = BSTsolution.buildTree(nodes, 0, nodes.length-1);
    BSTsolution.printTree(root);
  }

  public static void main(String[] args){
    BSTnode find = BSTsolution.find(root, 7);
    System.out.println("The data of found node is " + find.data);
    ////////////////////
    System.out.println("The level of node 7 is "+BSTsolution.getNodeLevel(root, 7, 0));
    System.out.println("The level of node 8 is "+BSTsolution.getNodeLevel(root, 8, 0));
    ////////////////////
    root.add(8);
    root.add(4);
    BSTsolution.printTree(root);
    System.out.println("The height of the binary search tree is " + BSTsolution.getHeight(root));
    ////////////////////
    BSTnode close = BSTsolution.getClosest(root, 15);
    System.out.println("The closest to " + 15 + " is " + close.data);
    ////////////////////
    BSTnode head = BSTsolution.convertToDoubleList(root);
    BSTsolution.printDList(head);
//    root.add(7);
//    if(BSTsolution.validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
//      System.out.println("no duplicate");
//    } else {
//      System.out.println("duplicate!!");
//    }

//    BSTnode a1, a2, a3, a5, a7;
//    a1 = new BSTnode(1);
//    a2 = new BSTnode(2);
//    a3 = new BSTnode(3);
//    a5 = new BSTnode(5);
//    a7 = new BSTnode(7);
//    a1.left = a2;
//    a2.right = a3;
//    a3.left = a5;
//    a3.right = a7;
//    int res = BSTsolution.getMaxPath(a1);
//    System.out.println("max is " + res);
  }
}
