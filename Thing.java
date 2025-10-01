import java.util.Random;
public abstract class Thing {
    private int row;
    private int col;
    private int dir;
    private char lab;
    public Thing(int row, int col, int dir, char lab) {
        this.row = row;
        this.col = col;
        this.dir = ((dir % 4) + 4) % 4;
        this.lab = lab;
    }

    public abstract void maybeTurn(Random rand);

    public void step() {
        final int[] dc = {0, 1, 0, -1};
        final int[] dr = {1, 0, -1, 0};
        this.row += dr[this.dir];
        this.col += dc[this.dir];
    }

    public void rightTurn() {
        this.dir = (this.dir + 1) % 4;
    }

    public void leftTurn() {
        this.dir = (this.dir + 3) % 4;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getDir() { return dir; }
    public char getLab() { return lab; }
    protected void setLab(char lab) { this.lab = lab; }
}
