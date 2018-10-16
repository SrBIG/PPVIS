package Model;

public class AntP {
    public static final int X = 1;
    public static final int Y = 2;

    private boolean needAway = false;
    private boolean away = false;
    private boolean needCenter = false;
    private boolean center = false;

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

    public void findNewWay(int x0, int y0){
        step=maxStep;
        if(x>x0){
            x--;
        } else if(x<x0){
            x++;
        }
        if(y>y0){
            y--;
        } else if(y<y0){
            y++;
        }
    }

    private int calcRoute(){
        if(Math.random() < 0.5){
            return -1;
        } else return 1;
    }

    public void goAway(int xExit, int yExit){
        if(x > xExit){
            x--;
        } else if(x < xExit){
            x++;
        }

        if(y > yExit){
            y--;
            return;
        } else if(y < yExit){
            y++;
            return;
        }

        away = true;
    }

    public void returnToAnthil(int xCenter, int yCenter){
        if(x > xCenter){
            x--;
        } else if(x < xCenter) {
            x++;
        }

        if(y > yCenter){
            y--;
            return;
        } else if(y < yCenter){
            y++;
            return;
        }

        center = true;
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

    public boolean isNeedAway() {
        return needAway;
    }

    public void setNeedAway(boolean needAway) {
        this.needAway = needAway;
    }

    public boolean isAway() {
        return away;
    }

    public boolean isNeedCenter() {
        return needCenter;
    }

    public void setNeedCenter(boolean needCenter) {
        this.needCenter = needCenter;
    }

    public boolean isCenter() {
        return center;
    }
}
