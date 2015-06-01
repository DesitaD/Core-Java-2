import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;


public class TakeARest {

    public static void main(String[] args) throws IOException {
        Color cl=new Color(0, 191, 255);
        BufferedImage myPicture = ImageIO.read(new File("D:/bgImage.jpg"));
        Toaster toasterManager = new Toaster();
        toasterManager.setToasterHeight(600);
        toasterManager.setToasterWidth(750);
        toasterManager.setMargin(100);
      //  toasterManager.setToasterColor(cl);
        toasterManager.setBackgroundImage(myPicture);
        toasterManager.setStep(5);
        toasterManager.setDisplayTime(10000);
        toasterManager.showToaster( "Hey, YOU... it's time to take a rest... go for a walk, eat something or just enjoy the life outside :) " );
        

    }

}
