package _3_Recursia;

public class Recursia_ex7 {
    public static  boolean num_func(int num){
        if (num<=0) return false;
        return
                (num%10%2 !=0) || num_func(num/10);
    }

    public static void main(String[] args) {
        int num;
        boolean res;
        res = num_func(123);
        if (res == false) System.out.println("YES");
        else System.out.println("NO");
        //
        res = num_func(82);
        if (res == false) System.out.println("YES");
        else System.out.println("NO");
        //
    }
}
