package Week0;

import java.util.Arrays;

/**
 *
 * @author Desislava
 */
public class MaxScalar {
    public static long maximalScalarSum(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int c=0;
        for(int i=0; i<a.length;i++){
             c+= a[i]*b[i];
        }
        return c;
    }
    
    public static void main(String []args){
        int[] a={2,4,7};
        int[] b={5,-3,10};
        System.out.println(maximalScalarSum(a,b));
        
    }
}
