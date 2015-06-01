package Week0;

/**
 *
 * @author Desislava
 */
public class MaxSpan {
    public static int maxSpan(int[] numbers){
      int a=0;
      for(int i=0;i <numbers.length;i++){
          int k=numbers.length-1;
          while(numbers[i]!=numbers[k])
              k--;
          if(a<k-i+1)
              a=k-i+1;
      }
      
      return a;      
    }
    
    public static void main(String []args){
        
    }
}
