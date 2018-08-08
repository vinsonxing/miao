package Algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/6/14
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class SumList {
//  int[] a1= {7,3,2,8};
//  int[] a2= {4,6,8,4};
//  LinkedList l1= new LinkedList(Arrays.asList(a1));
//  LinkedList l2= new LinkedList(Arrays.asList(a2));
//  Node num1= l1.createList();
//  Node num2= l2.createList();
//  Node result;
//
//  public static void main(String[] args) {
//    SumList sl= new SumList();
//    int c= sl.sum(sl.num1, sl.num2);
//    if(c>0) {
//      Node temp= new Node(c);
//      temp.next= sl.result;
//      sl.result= temp;
//    }
//
//    while(sl.result != null){
//      System.out.print(sl.result.data);
//      sl.result= sl.result.next;
//    }
//  }
//
//  int sum(Node n1, Node n2) {
//    if(n1==null || n2==null)
//      return 0;
//    int a1= this.getSize(n1);
//    int a2= this.getSize(n2);
//    int carry, s= 0;
//    if(a1>a2) {
//      carry= sum(n1.next, n2);
//      s= n1.data+carry;
//    }
//    else if(a2>a1) {
//      carry= sum(n1, n2.next);
//      s= n2.data+carry;
//    }
//    else {
//      carry= sum(n1.next, n2.next);
//      s= n1.data+n2.data+carry;
//    }
//    carry= s/10;
//    s=s%10;
//
//    Node temp= new Node(s);
//    temp.next= result;
//    result= temp;
//
//    return carry;
//  }
//
//  int getSize(Node n) {
//    int count =0;
//    while(n!=null) {
//      n=n.next;
//      count++;
//    }
//    return count;
//  }
}
