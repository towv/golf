package golfing.kiekko;

public class Sijainti {

    private int x;
    private int y;

    public Sijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean osuu(Sijainti sijainti) {
        return sijainti.getX() == getX() && sijainti.getY() == getY();
    }

    @Override
    public String toString() {
        return "" + this.x + this.y;
    }

}
