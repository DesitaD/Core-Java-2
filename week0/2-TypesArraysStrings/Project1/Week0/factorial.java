package Week0;

/**
 *
 * @author Desislava
 */
public class factorial {
    public static long doubleFac(int n){
        long dFact=1;
        for (int i=1;i<=n;i++){
            dFact*=i;
        }
        for (int j=(int)dFact;j<n;j--){
            dFact*=j;
        }
        return dFact;
    }
    
    public static void main(String []args){
        
    }
}
