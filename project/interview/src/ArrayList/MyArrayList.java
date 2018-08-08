package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qlu                      clone
 * Date: 14-12-4
 * Time: 上午10:39
 * To change this template use File | Settings | File Templates.
 */
public class MyArrayList {
  private static final int SIZE_FACTOR=5;
  private Object[] data;
  private int size;
  private int index;
  public MyArrayList(){
    this.data=new Object[SIZE_FACTOR];
    this.size=SIZE_FACTOR;
  }
  public void add(Object obj){
    if(this.index == this.size -1){
      increaseSizeAndReallocate();
    }
    data[this.index]=obj;
    this.index++;
  }
  private void increaseSizeAndReallocate(){
    this.size += SIZE_FACTOR;
    Object[] newData = Arrays.copyOf(data, size);
    this.data=newData;
  }
  public Object get(int i) throws Exception{
    if(i>this.index-1){
      throw new Exception("ArrayIndexOutOfBound");
    }
    if(i<0){
      throw new Exception("Negative value");
    }
    return this.data[i];
  }
  public void remove(int i) throws Exception{
    if(i>this.index-1){
      throw new Exception("ArrayIndexOutOfBound");
    }
    if(i<0){
      throw new Exception("Negative value");
    }
    for(int x=i;x<this.index;x++){
      data[x]=data[x+1];
    }
    this.index--;
  }
}
