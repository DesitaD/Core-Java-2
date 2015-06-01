package Week0;
/**
 *
 * @author Desislava
 */
public class SmallestMultiple {
   private static long lcm(long first,long second)
	{
	    long result = 1, temp = 1;
	    
	    for(int i = 1;; i++)
	    {
	        result = first*i;
	        
	        for(int j = 1; temp < result; j++)
	            temp = second*j;
	        
	        if(result == temp)
	            break;
	    }
	    return result;
	}
     public static long getSmallestMultiple(int upperBound){
         int temp=1;
         for (int i=upperBound;i<=1;i--){
             temp=(int)lcm(i,temp);
         }
         return temp;         
     }
    
    public static void main(String []args){
        
    }
}
