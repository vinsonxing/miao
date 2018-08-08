package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-15
 * Time: 下午5:15
 * To change this template use File | Settings | File Templates.
 */
public class ReverseLinklist {
  public static LinkNode reverse(LinkNode node){
    LinkNode prev = null;
    LinkNode next = null;
    int iteration = 0;
    while(node != null) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
      iteration++;
    }
    System.out.println("iteration time:"+iteration);
    return prev;
  }
  public static LinkNode reverse1(LinkNode node){
    if (node.next == null)
    {
      return node;
    }
    LinkNode prevNode = reverse1(node.next);
    LinkNode temp = node.next;
    temp.next = node;
    node.next = null;
    return prevNode;
  }
  public static void main(String[] args){
    LinkNode l1 = new LinkNode(2);
    LinkNode l2 = new LinkNode(4);
    LinkNode l3 = new LinkNode(5);
    LinkNode l4 = new LinkNode(9);
    l1.next=l2;
    l2.next=l3;
    l3.next=l4;

    printList(l1);
    LinkNode head = reverse(l1);
    System.out.println("=======");
    printList(head);
  }
  public static void printList(LinkNode l)
  {
    while(l!=null){
      System.out.print(l.value + " ");
      l=l.next;
    }
    System.out.println();
  }
}
class LinkNode {
  LinkNode next;
  int value;
  public LinkNode(int value){
    this.value = value;
  }
}
