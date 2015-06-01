package Week0;
import java.util.Arrays;

/**
 *
 * @author Desislava
 */
public class NumberOddTimes {
   public static int getOddOccurrence(int[] array){
       Arrays.sort(array);
       int br=1, i=1;
       int result =array[0];
      
       
       while(array.length >i){
           if(array[i-1]==array[i]){
               br++;
               i++;
           }
           if (br%2 != 0){
               result=array[i-1];
           }
           
           
           br=1;
           i++;
       }
       return result;
   }
   
    public static void main(String []args){
        int[] array={1,2,2,1,3,4,3,4,4,6,5,6,5};
        System.out.println(getOddOccurrence(array));
        
    }
}
