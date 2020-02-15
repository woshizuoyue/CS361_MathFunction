public class OCA_Test implements MatFunc{

    public static void main(String[] args){

        // input x value to x[0], x[1] is for the f(x);
        double[] x1 = new double[2];
        double[] x2 = new double[2];

        // 1. findxy -> get the two points that values
        // of one is positive and the other is negative;
        // it is for the bisection alg;
        new OCA_Test().findxy();

        //2. get value;
        //System.exit(0);

        // comment out 2. part, input the value from 2. part;

        x1[0] = 1;
        x2[0] = 2;
        x1[1] = -46;
        x2[1] = 620;
        double avg = (x1[0] + x2[0])/2.0;

        //3. find the closet value for bisection alg;
        System.out.println("avg :" + avg + "  " + "f:" + new OCA_Test().bisec(x1,x2));

        // this is for the Newton-Raphsion alg;

        // the result of f(x)/f'(x)
        //FFPrime y = new FFPrime(avg);

        //System.out.println(new OCA_Test().nRap(avg, y));

    }

    public final double func(double x){
        // function should be changed every time;
        return 40 * (x*x*x*x) + 6 * (x*x*x) + 10 * (x*x) - 6 * x - 96;
    }

    @Override
    public double nRap(double x, FFPrime y) {

        //xi - f(x)/f'(x)
        return x - y.getRes(x);
    }

    public double bisec(double[] x1, double[] x2){

        double avg = (x1[0] + x2[0]) / 2.0;

        double f = func(avg);

        System.out.println("x1:" + x1[0] + "..." + "x2:" + x2[0] + "..." + "avg :" +avg +"..." +"f:" + f);

        if(x1[1] > 0 && x2[1] < 0){

            if(f > 0 && f < x1[1]){

                x1[0] = avg;
                x1[1] = f;
            }

            else if(f < 0 && f > x2[1]){

                x2[0] = avg;
                x2[1] = f;
            }

            else {
                System.out.println("error in condition1");
            }
        }

        else if(x1[1] < 0 && x2[1] > 0){

            if(f > 0 && f < x2[1]){

                x2[0] = avg;
                x2[1] = f;
            }

            else if(f < 0 && f > x1[1]){

                x1[0] = avg;
                x1[1] = f;
            }
            else{
                System.out.println("error in condition2");
            }
        }

        bisec(x1, x2);
        return -1;
    }

    public void findxy(){

        int start = -100;
        int end = 100;

        // function;
        double f1 = 0;
        double f2 = 0;

        for(int i = start; i<=end; ++i){
            int a = i + 1;

            f1 = func(i);
            f2 = func(a);

            if(f1 > 0 && f2 < 0){

                System.out.println("i:" + i + "..." + "i+1: " + a +"..."+ "f1:" + f1 +"..." + "f2:" +f2);
            }
            else if(f1 <0 && f2 > 0){

                System.out.println("i:" + i + "..." + "i+1: " + a + "..." + "f1:" + f1 + "..." +"f2:" + f2);
            }

            else{
                //System.out.println("error in findxy");
            }
        }
    }
}

class FFPrime {

    double x;

    FFPrime(double x){

        this.x = x;
    }

    public double getRes(double x){

        //f(x)
        double f = 40 * (x*x*x*x) + 6 * (x*x*x) + 10 * (x*x) - 6 * x - 96;

        //f'(x)
        double fprime = 160*(x*x*x) + 18*x*x + 20*x - 6;

        return f / fprime;
    }
}
