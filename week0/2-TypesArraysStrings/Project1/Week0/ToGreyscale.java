package Week0;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author Desislava
 */
public class ToGreyscale {
    public static void convertToGreyscale(String imgPath)throws IOException{
      BufferedImage img = null;
      File f = null;
      
      try {
          f = new File(imgPath);
          img = ImageIO.read(f);
      }
      catch (IOException e){
          System.out.println(e);
      }
      
      int width = img.getWidth();
      int height = img.getHeight();
      
      for (int i = 0; i< height; i++){
          for(int j= 0; j< width; j++){
              int p = img.getRGB(j, i);
              
              int a = (p>>24)&0xff;
              int r = (p>>16)&0xff;
              int g = (p>>8)&0xff; 
              int b = p&0xff;
              
              int avg = (r+g+b)/3;
              
              p = (a>>24) | (avg>>16) | (avg>>8) | avg;
              img.setRGB(j,i,p);
            }
        }
      try {
          f= new File("");
          ImageIO.write(img, imgPath, f);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){

    }
}
