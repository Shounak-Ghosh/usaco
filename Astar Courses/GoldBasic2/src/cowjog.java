import java.util.*;
public class cowjog
{

   public static void main(String[] args)
   {

      Scanner sc = new Scanner(System.in);


      int n = sc.nextInt();
      cow[] myCows = new cow[n];
      for (int i=0; i<n; i++) {
         int pos = sc.nextInt();
         int speed = sc.nextInt();
         myCows[i] = new cow(pos, speed);
      }


      Arrays.sort(myCows);

      int cnt = 0, curPos = -1;
      for (int i=0; i<n; i++) {
         if (myCows[i].pos > curPos) {
            cnt++;
            curPos = myCows[i].pos;
         }
      }


      System.out.print(cnt);

   }
}

class cow implements Comparable<cow> {

   public int pos;
   public int speed;

   public cow(int start, int velocity) {
      pos = start;
      speed = velocity;
   }


   public int compareTo(cow other) {
      if (this.speed != other.speed) return this.speed-other.speed;
      return this.pos - other.pos;
   }
}