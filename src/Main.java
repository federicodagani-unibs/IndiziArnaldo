import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;

public class Main {
    public static final String DIR_CB_PESCA = "src/immagine_da_internet.png";
    public static final String DIR_CB_SCRIVI = "src/wrong_size.png";

    public static void main(String[] args) throws Exception {

        int width = 232, height = 232;
        BufferedImage img_iniziale = ImageIO.read(new File(DIR_CB_PESCA));
        WritableRaster wr = img_iniziale.getRaster() ;
        //trovo la dimensione dell'array di pixel
        int c=0;
        for (int y=0 ; y < img_iniziale.getHeight() ; y++){
            for (int x=0 ; x < img_iniziale.getWidth() ; x++){
                c++;
            }
        }
        //creo l'array
        int x,y, i=0;
        int[] pixels = new int[c];
        for (y=0 ; y < img_iniziale.getHeight() ; y++){
            for (x=0 ; x < img_iniziale.getWidth() ; x++){
                pixels[i] = wr.getSample(x, y, 0) ;
                i++;
            }
        }
        //in base al valore dei pixel dell'array, setto nell'immagine finale(ridimensionata) il colore(in questo caso bianco o nero)
        BufferedImage img_finale = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        i=0;
        for(y=0; y<width; y++){
            for(x=0; x<height; x++){
                if(pixels[i] == 0){
                    img_finale.setRGB(x,y, Color.black.getRGB());
                }else {
                    img_finale.setRGB(x,y,Color.white.getRGB());
                }
                i++;
            }
        }
        ImageIO.write(img_finale, "png", new File(DIR_CB_SCRIVI));
        System.out.println("qr code creato :)");
    }
}
