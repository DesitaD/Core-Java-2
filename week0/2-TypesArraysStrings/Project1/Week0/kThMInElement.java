package Week0;
import java.util.Arrays;
/**
 *
 * @author Desislava
 */
public class kThMInElement {
    
    public static int kthMin(int k, int [] array){
	Arrays.sort(array);
        return array[k-1];		
  }
    
    public static void main(String []args){
        
    }
}
