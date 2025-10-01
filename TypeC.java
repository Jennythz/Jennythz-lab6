import java.util.Random;

public class TypeC extends Thing {
    private boolean toggleRight = true;
    private int stepsBeforeTurn = 1;
    private int stepCounter = 0;

    public TypeC(int row, int col, int dir, char lab) {
        super(row, col, dir, lab);
    }

    @Override
    public void maybeTurn(Random rand) {
        stepCounter++;
        if (stepCounter >= stepsBeforeTurn) {
            stepCounter = 0;
            if (toggleRight) rightTurn(); else leftTurn();
            toggleRight = !toggleRight;
            stepsBeforeTurn++;
        }
    }
}
