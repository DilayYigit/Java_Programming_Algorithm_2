public abstract class Shape2D {
    protected int x;
    protected int y;
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    //getter methods
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //methods
    public double calculateDistance(Object anyShape) {
        if (anyShape instanceof Shape2D) {
            return Math.sqrt(Math.pow((x - ((Shape2D) anyShape).getX()), 2)
                    + Math.pow((y - ((Shape2D) anyShape).getY()), 2));
        } else {
            return -1;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Shape2D) {
            return x == ((Shape2D) o).getX() && y == ((Shape2D) o).getY();
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "For this 2D shape, x = " + x + " , y = " + y;
    }

}
