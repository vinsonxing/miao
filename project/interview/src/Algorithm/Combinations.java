package Algorithm;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 循环调用递归程序设计
 比排列程序难度大，在循环之中定义退出，循环次数是变量
 */
public class Combinations {
  private StringBuilder out = new StringBuilder();
  private final String in;
  public Combinations( final String str ){ in = str; }
  public void combine() { combine( 0 ); }
  private void combine(int start ) {
    for( int i = start; i < in.length(); ++i ) {
      out.append( in.charAt(i) );
      System.out.println( out );
      if ( i < in.length() )
        combine( i + 1);
      out.setLength( out.length() - 1 );
    }
  }

  public static void main(String[] args){
    Combinations c = new Combinations("abcd");
    c.combine();
  }
}
