package Algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 9/2/14
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Robot {
  int targetX, targetY;
  int move(int x, int y)
  {
    if(x-targetX==1 && targetY-y==1){
      return 2;
    }
    if(x-targetX==1 && targetY==y){
      return 1;
    }
    if(x==targetX && targetY-y==1){
      return 1;
    }
    return move(x+1, y) + move(x, y-1);
  }
}
