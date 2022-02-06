import java.util.ArrayList;
import java.util.Scanner;
public class ShapeTest {

    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);

        //I made a menu to look program good. I use arraylist here. At the bottom, I use numbers that are in the lab pdf.
        ArrayList<Shape2D> shapes = new ArrayList<>();
        int menu;
        do {
            System.out.println();
            System.out.println("Which shape do you want to create: ");
            System.out.println("\n1- Rectangle \n2- Circle \n3- Square \n4- Exit and Print the sample run from the lab pdf. ");
            menu = scan.nextInt();
            if (menu == 1) {
                System.out.println("Enter location: ");
                int x = scan.nextInt();
                int y = scan.nextInt();

                System.out.println("Enter width and height: ");
                int width = scan.nextInt();
                int height = scan.nextInt();

                Shape2D rectangle = new Rectangle(x,y,width,height);
                shapes.add(rectangle);

                System.out.println(rectangle.toString());
                System.out.println("Rectangle Calculations: ");
                System.out.println("Area: " + rectangle.calculateArea());
                System.out.println("Perimeter: " + rectangle.calculatePerimeter());
            }
            else if (menu == 2) {
                System.out.println("Enter location: ");
                int x = scan.nextInt();
                int y = scan.nextInt();

                System.out.println("Enter radius: ");
                int radius = scan.nextInt();

                Shape2D circle = new Circle(x,y,radius);
                shapes.add(circle);

                System.out.println(circle.toString());
                System.out.println("Circle Calculations: ");
                System.out.println("Area: " + circle.calculateArea());
                System.out.println("Perimeter: " + circle.calculatePerimeter());
            }
            else if (menu == 3) {
                System.out.println("Enter location: ");
                int x = scan.nextInt();
                int y = scan.nextInt();

                System.out.println("Enter side: ");
                int side = scan.nextInt();

                Shape2D square = new Square(x,y,side);
                shapes.add(square);

                System.out.println(square.toString());
                System.out.println("Square Calculations: ");
                System.out.println("Area: " + square.calculateArea());
                System.out.println("Perimeter: " + square.calculatePerimeter());
            }
        } while (menu != 4);

        //---------------------------------------------------------------------------------------
        //This part is for the numbers that are in the lab pdf and I use array in this part.

        Circle c = new Circle(13, 15, 3);
        Square s = new Square(-2, -5, 5);
        Rectangle r = new Rectangle(2, 3, 8, 15);
        Square s2 = new Square(-2, -5, 5);
        Square s3 = new Square(-1, -5, 5);
        Square s4 = null;
        Shape2D[] list = {c , s, r};
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));
        System.out.println(s.equals(s4));
        System.out.println(s.equals(c));


        System.out.println( findLargestArea(list) + " has largest area.");
        System.out.println(findLongestPerimeter(list) + " has longest perimeter.");
        System.out.println("Distance between rectangle and circle: "+ r.calculateDistance(c));
        System.out.println("Distance between rectangle and square: "+r.calculateDistance(s));
        System.out.println("Distance between circle and square: "+c.calculateDistance(s));

    }
    //methods
    public static Shape2D findLargestArea(Shape2D[] shapeArray){

        Shape2D shapes[] = shapeArray;
        Shape2D largest = shapes[1];
        for(int i = 0; i < shapeArray.length; i++)
        {
            if(shapeArray[i].calculateArea() > largest.calculateArea())
            {
                largest = shapeArray[i];
            }
        }
        return largest;
    }
    public static Shape2D findLongestPerimeter(Shape2D[] shapeArray){

        Shape2D shapes[] = shapeArray;
        Shape2D largest = shapes[1];
        for(int i = 0; i < shapeArray.length; i++)
        {
            if(shapeArray[i].calculatePerimeter() > largest.calculatePerimeter())
            {
                largest = shapeArray[i];
            }
        }
        return largest;
    }

}
