import java.util.*;

public class DotChaser {
  public static void main(String[] args) {
    int N = 200;
    if (args.length != 0) N = Integer.parseInt(args[0]);

    Random rand = new Random(System.currentTimeMillis());
    ThingList list = new ThingList();
    int count = 0;

    while (true) {
      if (count % N == 0) {
        list.add(new TypeA(45, 50, 0, 'r'));
        list.add(new TypeB(55, 50, 0, 'b'));
      }

      for (Thing t : list) {
        System.out.println(t.getRow() + " " + t.getCol() + " " + t.getLab());
      }
      System.out.println("done");
      System.out.flush();

      for (Thing t : list) {
        t.maybeTurn(rand);
        t.step();
      }
      count++;
    }
  }
}
