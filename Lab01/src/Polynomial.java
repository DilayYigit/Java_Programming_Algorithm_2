public class Polynomial {
    private double[] coef;
    private int d;
    private double c;
    public Polynomial(int d, double c) {
        this.d = d;
        this.c = c;
       coef = new double[d+1];
       coef[d] = c;
    }
    public Polynomial() {
        int degree = 1;
        coef = new double[degree];
        coef[0] = 0;
    }
    public Polynomial(double[] coef2) {
        this.d= coef2.length - 1;
        coef = new double[coef2.length];
        for (int i = 0; i < coef.length; i++) {
            coef[i] = coef2[i];
        }
    }
    public double getter (int d) {
        if (this.d < d) {
            return 0;
        }
        return coef[d];
    }
    public int getDegree() {
        int degree = 0;
        for (int i = 0; i <= coef.length - 1; i++) {
            if(coef[i] != 0)
            {
                degree = i;
            }
        }
        return degree;
    }
    public String toString() {
        String s;
        if (d == 0)
        {
            return "" + coef[0];
        }
        if (d == 1) {
            return coef[1] + "x + " + coef[0];
        }
        s = coef[d] + "x^" + d + " + ";

        for( int i = d - 1; i >= 0; i-- ){
            System.out.println(i);
            if(coef[i] == 0) { }
            else if(coef[i] > 0)
            {
                s = s + " + " + (coef[i]);
                if( i == 1 )
                {
                    s = s + "x";
                }
                else if( i > 1 ) {
                    s = s + "x^" + i;
                }
            }
            else if(coef[i] < 0) {
                s = s + " - " + (-coef[i]);
                if( i == 1 )
                {
                    s = s + "x";
                }
                else if( i > 1 ) {
                    s = s + "x^" + i;
                }
            }

        }
        return s;
    }
    public double eval (double x) {
        double calc = 0;
        if (d==0) {
            return 0;
        }
        else if (d==1) {
            return coef[0];
        }
        else {
            for (int i = d; i >= 0; i--) {
                calc = calc + coef[i]*(Math.pow(x,i));
            }
        }
        return calc;
    }
    public double eval2 (double x) {
        double result2 = 0;
        for (int j = d; j >=0; j--) {
            result2 = coef[j] + (x*result2);
        }
        return result2;
    }

}
