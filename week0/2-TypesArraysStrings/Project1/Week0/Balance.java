package Week0;

/**
 *
 * @author Desislava
 */
public class Balance {
    public static boolean canBalance(int[] numbers){
        boolean flag= false;
        for(int i=0;i < numbers.length;i++){
            int k= numbers.length-1,counter=0;
            int right=0,left=0;
            while(counter <= i){
                right+=numbers[counter];
                counter++;
            }
            while (k!=i){
                left+=numbers[k];
                k--;
            }
            if(left==right){
                flag = true;
                break;
            }
            else{
                flag = false;
            }
            i++;
        }
        
        return flag;
    }
    
    public static void main(String []args){
            int[] num={1, 1, 1, 2, 1};
            System.out.println(canBalance(num));
    }
}
