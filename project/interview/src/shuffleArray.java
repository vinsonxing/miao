/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 14-11-28
 * Time: 下午5:50
 * To change this template use File | Settings | File Templates.
 */
public class shuffleArray {
  public static void shufferArray(int[] cards){
    int temp, index;
    for(int i=0; i< cards.length; i++){
      double random = Math.random();
      System.out.println("random is "+random);
      index = (int)(random * (cards.length - i)) + i;
      temp = cards[i];
      cards[i] = cards[index];
      cards[index] = temp;
    }
  }
  public static void output(int[] cards){
    for(int i=0; i<cards.length; i++){
      System.out.print(cards[i] + " ");
    }
  }
  public static void main(String[] args) {
    int[] cards = new int[]{3, 4, 1, 8, 2};
    shufferArray(cards);
    output(cards);
  }
}
