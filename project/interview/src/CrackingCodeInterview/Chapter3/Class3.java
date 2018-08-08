package CrackingCodeInterview.Chapter3;

import java.util.Stack;
import java.util.ArrayList;

public class Class3 {
  class SetOfStacks{
    int capacity;
    ArrayList<Stack> stacks = new ArrayList<Stack>();

    public SetOfStacks(int capacity){
      this.capacity = capacity;
    }
    public Stack getLastStack()
    {
      if(stacks.size() == 0)
      {
        return null;
      }
      return stacks.get(stacks.size() - 1);
    }
    void push(int v){
      Stack last = getLastStack();
      if(last != null )//&& last.isFull())
      {
        last.push(v);
      }
      else {
        Stack stack = new Stack();
        stacks.add(stack);
        stack.push(v);
      }
    }
    int pop()
    {
      Stack last = getLastStack();
      Object v = last.pop();
      return (Integer)v;
    }
  }

}
