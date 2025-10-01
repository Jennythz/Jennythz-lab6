import java.util.Random;
public class TypeB extends Thing {
    private int timeSinceLast = 0;

    public TypeB(int row, int col, int dir, char lab) {
        super(row, col, dir, lab);
    }

    @Override
    public void maybeTurn(Random rand) {
        timeSinceLast++;
        if (timeSinceLast == 10) {
            timeSinceLast = 0;
            int i = rand.nextInt(3); 
            if (i == 1) rightTurn();
            if (i == 2) leftTurn();
        }
    }
}
