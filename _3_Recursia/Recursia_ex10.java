package _3_Recursia;

public class Recursia_ex10 {
    public static double sod (int n, double a[], double p, double x)
    {
        if (n==0) return 0;
        return a[n-1]*p+ sod(n-1,a,p*x,x);
    }

    public static void main(String[] args) {
        double a[]={1,2,3,4,0,6,0,0,5,4};
        System.out.println("RESULT = "+ sod(4,a,1,2));
    }
}
