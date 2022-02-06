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
        for (int i = coef.length -1; i >= 0; i--) {
            if(coef[i] != 0)
            {
                return i;
            }
        }
        return 0;
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
    public Polynomial add (Polynomial p2) {
        Polynomial p1 = this;
        Polynomial result = new Polynomial(Math.max(p1.getDegree(),p2.getDegree()), 0);
        for (int i = 0; i<= p1.getDegree(); i++) {
            result.coef[i] = result.coef[i] + p1.coef[i];

        }
        for (int j = 0; j<= p2.getDegree(); j++) {
            result.coef[j] = result.coef[j] + p2.coef[j];
        }
        return result;
    }
    public Polynomial sub (Polynomial p2) {
        Polynomial p1 = this;
        Polynomial result = new Polynomial(Math.max(p1.getDegree(),p2.getDegree()), 0);
        for (int i = 0; i<=p1.getDegree(); i++) {
            result.coef[i] = result.coef[i] + p1.coef[i];
        }
        for (int j = 0; j<=p2.getDegree(); j++) {
            result.coef[j] = result.coef[j] - p2.coef[j];
        }
        return result;
    }
    public Polynomial mul (Polynomial p2) {
        Polynomial p1 = this;
        Polynomial result = new Polynomial(p1.getDegree()+p2.getDegree(),0);
        for (int i = 0; i <= p1.getDegree(); i++) {
            for (int j = 0; j <= p2.getDegree(); j++) {
                result.coef[i+j] = result.coef[i+j] + (p1.coef[i] * p2.coef[j]);
            }
        }
        return result;
    }
    public Polynomial compose (Polynomial p2) {
        Polynomial p1 = this;
        Polynomial result = new Polynomial();
        for (int i = p1.getDegree(); i >=0; i--) {
            int counter = (int) p1.coef[i];
            Polynomial e2 = new Polynomial(0, counter);
            result = e2.add(p2.mul(result));
        }
        return result;
    }
    public Polynomial div (Polynomial p2) {
        Polynomial p1 = this;
        Polynomial result = new Polynomial();
        Polynomial print = new Polynomial();
        while (p1.getDegree()>p2.getDegree()) {
            int deg = this.getDegree();
            double lead1 = this.getter(deg);
            int deg2= p2.getDegree();
            double lead2 = p2.getter(deg);
            Polynomial t = new Polynomial((int) (lead1 - lead2), lead1/lead2);
            result = p1.sub(p2.mul(t));
            print = print.add(t);
        }
        return print;
        }
    }
