class Point {
    int x,y;

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceBtPoints() {
        return Math.sqrt((x*x) + (y*y));
    }
}

public class DistanceBT2Points {
    public static void main(String[] args) {
        Point p = new Point(2,3);
        System.out.println(p.distanceBtPoints());
    }
}
