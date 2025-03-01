package _3_Recursia;

public class Recursia_ex8 {
    public static int func(int x[], int y[], int s){
        if(s==0) return 0;
        return x[s-1]*y[s-1]+func(x,y,s-1);
    }

    public static void main(String[] args) {
        int vec1[]={1,2,1,2,1,2,1};
        int vec2[]={1,-2,3,4,5,-6,7};
        System.out.println("RESULT = "+func(vec1,vec2,vec1.length));
    }
}
