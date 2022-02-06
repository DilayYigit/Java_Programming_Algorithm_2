public class Rectangle extends Shape2D {
    int width;
    int height;
    public Rectangle(int x, int y, int width,int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    //getter methods
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    //overrides
    @Override
    public double calculateArea() {
        return height*width;
    }
    @Override
    public double calculatePerimeter() {
        return 2*(width+height);
    }
    @Override
    public String toString() {
        return "This is a rectangle with width and height: " + width
                + ", " + height + ". " + super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Rectangle) {
            return super.equals(o) && height == ((Rectangle) o).getHeight()
                    && width == ((Rectangle) o).getWidth();
        } else {
            return false;
        }
    }
}
