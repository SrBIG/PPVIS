package Model;

public class AntP {
    public static final int X = 1;
    public static final int Y = 2;

    private int x;
    private int y;
    private int size;
    private int step = 0;
    private int maxStep = 10;
    int routeX;
    int routeY;

    public AntP(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void calcWay(){
        int moveX;
        int moveY;
        if(step == maxStep) {
            step = 0;
            routeX = calcRoute();
            routeY = calcRoute();
        }

        moveX = (int)(Math.random()*2);
        moveY = (int)(Math.random()*2);

        if(moveX == 1){
            x+=routeX;
        }
        if(moveY == 1){
            y+=routeY;
        }

        step++;
    }

    private int calcRoute(){
        if(Math.random() < 0.5){
            return -1;
        } else return 1;
    }

    public void stopMove(int coord){
        if(X == coord){
            routeX = -routeX;
        } else if (Y == coord){
            routeY = -routeY;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }
}
