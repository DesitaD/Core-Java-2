package Week0;

/**
 *
 * @author Desislava
 */
public class IntegerOfPower {
  public static long pow(int a, int b){
      if (b==0){
          return 1;
      }
      long result=pow(a,b/2);
      result *= result;
      
      if(b%2 != 0){
       result*=a;   
      }  
      return result;
  }  
  public static void main(String []args){
        System.out.println(pow(4,2));
    }
}
