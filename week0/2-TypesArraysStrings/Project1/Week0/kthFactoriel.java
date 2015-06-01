package Week0;

/**
 *
 * @author Desislava
 */
public class kthFactoriel {
    public static long kthFac(int k, int n){
        long dFact=1;
        for (int i=n;i>=k-1;i-=k){
            dFact*=i;
        }
       return dFact; 
    }
    public static void main(String []args){
        System.out.println(kthFac(10,100));
    }
}
