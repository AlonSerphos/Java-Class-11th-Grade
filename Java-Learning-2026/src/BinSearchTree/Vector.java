package BinTreeTasks;
//Alon Serphos
public class Vector implements Comparable<Vector> {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public double getAngle() {
        return Math.atan2(y, x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Vector other) {
        double thisLen = this.getLength();
        double otherLen = other.getLength();

        if (thisLen < otherLen) {
            return -1;
        } else if (thisLen > otherLen) {
            return 1;
        } else {
            return 0;
        }
    }
}
