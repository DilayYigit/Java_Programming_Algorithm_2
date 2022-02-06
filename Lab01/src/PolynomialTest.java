public class PolynomialTest {

    public static void main(String[] args) {
	Polynomial e1 = new Polynomial(5,4);
	Polynomial e2 = new Polynomial();
	Polynomial e3 = new Polynomial(new double[]{1, 2, 3, 4, 5});
        System.out.println(e1.toString());
        System.out.println(e1.getter(5));
        System.out.println(e1.getDegree());
        System.out.println(e1.eval(2));
        System.out.println(e1.eval2(2));
        System.out.println();
        System.out.println(e2.toString());
        System.out.println(e2.getter(5));
        System.out.println(e2.getDegree());
        System.out.println(e2.eval(2));
        System.out.println(e2.eval2(2));
        System.out.println();
        System.out.println(e3.toString());
        System.out.println(e3.getter(5));
        System.out.println(e3.getDegree());
        System.out.println(e3.eval(2));
        System.out.println(e3.eval2(2));
    }
}
