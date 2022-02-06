public class Circle extends Shape2D {
    int radius;
    public Circle(int x, int y,int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //getter method
    public double getRadius() {
        return radius;
    }
    //overrides
    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2*(Math.PI)*radius;
    }
    @Override
    public String toString() {
        return "This a circle with radius: " + radius + ". " + super.toString();

    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            return super.equals(o) && radius == ((Circle) o).getRadius();
        } else {
            return false;
        }
    }

}
