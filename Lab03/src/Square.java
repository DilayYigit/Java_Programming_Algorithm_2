public class Square extends Rectangle {
    int side;
    public Square(int x, int y, int side) {
        super(x, y, side, side);
    }
    //getter method
    private int getSide() {
        return side;
    }

    //overrides
    @Override
    public String toString() {
        return "This is a square with side length of: " + side
                + ". " + super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Square) {
            return super.equals(o) && side == ((Square) o ).getSide();
        } else {
            return false;
        }
    }

}
