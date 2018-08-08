package Algorithm.BST;

import java.util.Arrays;
import java.util.ArrayList;

public class BSTsolution {

  static BSTnode buildTree(BSTnode[] nodes, int start, int end) {
    if(start > end){
      return null;
    }
    int middle = (start + end)/2;
    BSTnode root = nodes[middle];
    root.left = buildTree(nodes, start, middle-1);
    root.right = buildTree(nodes, middle+1, end);
    return root;
  }

  static BSTnode find(BSTnode node, Comparable value){
    if(node == null) {
      return null;
    }
    if(node.data.compareTo(value) == 0){
      return node;
    }
    BSTnode found = find(node.left, value);
    if(found != null) {
      return found;
    }
    else found = find(node.right, value);
    if(found != null) {
      return found;
    }
    return found;
  }

  static int getHeight(BSTnode root){
    if(root == null) {
      return 0;
    }
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.max(left, right) + 1;
  }

  static boolean validate(BSTnode root){
    if(root == null) {
      return true;
    }
    boolean isLeftBST = validate(root.left);
    boolean isRightBST = validate(root.right);
    if(isLeftBST && isRightBST && root.left.data.compareTo(root.data) == -1  && root.data.compareTo(root.right.data) == -1) {
      return true;
    }
    return false;
  }

  // check duplicate
  static boolean validate(BSTnode root, int MIN, int MAX){
    if(root == null) {
      return true;
    }
    boolean isLeftValidate = validate(root.left, MIN, (Integer)root.data);
    boolean isRightValidate = validate(root.right, (Integer)root.data, MAX);
    if(isLeftValidate && isRightValidate && (Integer)root.data > MIN && (Integer)root.data < MAX) {
      return true;
    }
    return false;
  }

  static BSTnode getClosest(BSTnode root, Comparable value){
    if(root == null){
      return null;
    }
    int min = 0, left = -1, right = -1;
    BSTnode leftChild = new BSTnode(left), rightChild = new BSTnode(right);
    min = Math.abs((Integer)value - (Integer)root.data);
    if(root.left != null) {
      leftChild = getClosest(root.left, value);
      if(leftChild != null) {
        left = Math.abs((Integer)leftChild.data - (Integer)value);
      }
    }
    if(root.right != null) {
      rightChild = getClosest(root.right, value);
      if(rightChild != null) {
        right = Math.abs((Integer)rightChild.data - (Integer)value);
      }
    }
    if(min <= left && left >=0 && min <= right && right >= 0 || left == -1 && right == -1) {
      return root;
    } else if(left >= 0 && left <= min && left <= right) {
      return leftChild;
    } else {
      return rightChild;
    }
  }
  // inorder traversal
  static void printTree(BSTnode root) {
     if(root == null){
       return ;
     }
     if(root.left != null){
       printTree(root.left);
     }
    System.out.print(root.data + " ");
    if(root.right != null){
      printTree(root.right);
    }
  }
  /**
   * Convert BST to double linked list
   */
  static BSTnode convertToDoubleList(BSTnode root){
    if(root == null) {
      return null;
    }
    BSTnode leftMax = convertToDoubleList(root.left);
    BSTnode rightMin = convertToDoubleList(root.right);
    root.left = root.right = null;
    BSTnode list = append(leftMax, root);
    list = append(list, rightMin);
    return list;
  }
  static BSTnode append(BSTnode a, BSTnode b) {
    if(a == null) return b;
    if(b == null) return a;
    //a, b
    BSTnode head = a;
    while(a.right != null && a.right != b) {
      a = a.right;
    }
    a.right = b;
    b.left = a;
    return head;
  }

  static void printDList(BSTnode head){
    System.out.println();
    System.out.println("left to right");
    while(head != null){
      System.out.print(head.data + " ");
      head = head.right;
    }
  }

  static int getNodeLevel(BSTnode root, Comparable value, int currLevel){
    if(root == null) return -1;
    if(root.data.compareTo(value) == 0) {
      return currLevel;
    }
    int left = getNodeLevel(root.left, value, currLevel+1);
    int right = getNodeLevel(root.right, value, currLevel+1);
    if(left != -1) {
      return left;
    }
    if(right != -1){
      return right;
    }
    return -1;
  }

  /*
   ** Get the path with the max sum value
   */
  static ArrayList<BSTnode> getMaxPath(BSTnode root){
    if(root == null) {
      return null;
    }
    ArrayList<BSTnode> leftPath = getMaxPath(root.left);
    ArrayList<BSTnode> rightPath = getMaxPath(root.right);
    if(leftPath.contains(root.left)) {
      leftPath.add(root);
    }
    return null;
  }
  static int getSum(ArrayList<BSTnode> nodes) {
    int sum = 0;
    for(BSTnode node : nodes) {
      sum += (Integer)node.data;
    }
    return sum;
  }

}
