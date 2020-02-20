public interface MatFunc {

    double bisec(double[] x1, double[] x2);
    double nRap(double x, FFPrime y);
    void findxy();
    // function should be changed every time;
    double func(double x);

    double numericDiffer();

}
