package CrackingCodeInterview.Chapter3;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/30/14
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Class6 {
  public static void main(String[] args)
  {
    stack<Integer> original = new stack<Integer>(7);
    original.push(4);
    original.push(5);
    original.push(3);
    original.push(2);
    original.push(1);
    original.push(7);
    original.push(9);
    stack<Integer> result = sort(original);
    while(!result.isEmpty())
    {
      System.out.println(result.pop());
    }
  }

  public static stack<Integer> sort(stack<Integer> s){
    int size = s.size();
    stack<Integer> r = new stack<Integer>(size);
    while(!s.isEmpty())
    {
      int temp = s.pop();
      while(!r.isEmpty() && r.peek() > temp)
      {
        s.push(r.pop());
      }
      r.push(temp);
    }
    return r;
  }
}

class stack<T>{
  private int top = -1;
  private int size;
  private T[] elements;

  public stack(int size){
    this.size = size;
    elements = (T[]) new Object[size];
  }
  void push(T element)
  {
    if(top == elements.length - 1)
    {
      throw new FullStackException("stack is full");
    }
    elements[++top] = element;
  }
  T pop()
  {
    T res = elements[top];
    top--;
    return res ;
  }
  T peek()
  {
    return elements[top];
  }
  boolean isEmpty()
  {
    if(top == -1)
    {
      return true;
    }
    return false;
  }

  int size()
  {
    return top+1;
  }
}

class FullStackException extends RuntimeException {
  public FullStackException() {
    this("Stack is full");
  }

  public FullStackException(String exception) {
    super(exception);
  }
}
