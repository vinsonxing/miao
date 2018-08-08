package CrackingCodeInterview.Chapter3;

import java.util.Stack;
/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 8/3/14
 * Time: 6:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class2 {
  class StackWithMin extends Stack<Integer> {
    Stack<Integer> s2;

    public StackWithMin(int size){
      s2 = new Stack<Integer>();
    }
    public void push(int element)
    {
      if(element < getMin())
      {
        s2.push(element);
      }
      super.push(element);
    }
    int getMin(){
      if(s2.isEmpty())
      {
        return Integer.MAX_VALUE;
      }
      else {
        return s2.peek();
      }
    }
    public Integer pop()
    {
      int temp = super.pop();
      if(temp == getMin())
      {
        s2.pop();
      }
      return temp;
    }
    public Integer peek()
    {
      return super.peek();
    }
  }
}
