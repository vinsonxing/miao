package Algorithm;

/**
 循环调用递归程序设计, 外层for循环与递归次数无直接联系，而是从实际问题分析入手的第一层循环
 在这道题里，调用递归同样会遍历单词字母个数遍次数，每次append的字母要靠used全局标志数组进行判断
 当满足条件时，即输出字母个数已经达到原字符串长度；
 出栈后最后的字母要去掉，特征是入栈出栈前后操作都与循环变量i有直接关系
 */
public class Permutations {
  private boolean[] used;
  private StringBuilder out = new StringBuilder();
  private final String in;
  public Permutations( final String str ){
    in = str;
    used = new boolean[ in.length() ];
  }
  public void permute( ){
    if( out.length() == in.length() ){
      System.out.println( out );
      return;
    }
    for( int i = 0; i < in.length(); ++i ){
      if( used[i] ) continue;
      out.append( in.charAt(i) );
      used[i] = true;
      permute();
      used[i] = false;
      out.setLength( out.length() - 1 );
    }
  }

  public static void main(String[] args)
  {
    new Permutations("abcd").permute();
  }

}
