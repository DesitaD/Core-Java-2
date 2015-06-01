package Week0;

/**
 *
 * @author Desislava
 */
public class Histogram {
    public static int[] histogram(short[][] image){
        int [] result=new int[257];
        int counter=0;
        for(int index=0;index<256;index++){
            counter=0;
        for(int row=0;row<image.length;row++){
            for (int col=0;col<image[0].length;col++){
                if(index==image[row][col]){
                    counter++;
                }
            }
            result[index]=counter;
        }
        }
        return result;
    }
 
    public static void main(String[] args){
        
    }
}
