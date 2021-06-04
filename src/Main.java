import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static final String DIR_AR = "src/shide.jpg";
    public static final String DIR_IEE = "src/header_ieee.jpg";
    public static final String DIR_CB_PESCA = "src/immagine_da_internet.png";
    public static final String DIR_INDIZIO = "src/immagine_singola.jpg";
    public static final String DIR_CB_SCRIVI = "src/wrong_size.png";

    public static void main(String[] args) throws Exception {

        /*
        File fi_ar = new File(DIR_AR);
        byte[] fileContent_ar = Files.readAllBytes(fi_ar.toPath());

        File fi_ieee = new File(DIR_IEE);
        byte[] fileContent_ieee = Files.readAllBytes(fi_ieee.toPath());
         */

        File cb_file = new File(DIR_CB_PESCA);
        byte[] cb_byte_arr = Files.readAllBytes(cb_file.toPath());

        /*
        int dim = cb_byte_arr.length;
        byte[] cb_byte_arr_mini = new byte[dim];
        for(int i=0; i<dim; i++){
            if(i<213 || i>4216){
                cb_byte_arr_mini[i] = cb_byte_arr[i];
            }
        }
         */

        ByteArrayInputStream bis = new ByteArrayInputStream(cb_byte_arr);
        BufferedImage bImage2 = ImageIO.read(bis);
        BufferedImage scaledImage = resizeImage(bImage2, 10, 250);
        ImageIO.write(scaledImage, "png", new File(DIR_INDIZIO));
        ImageIO.write(scaledImage, "png", new File(DIR_CB_SCRIVI) );
        System.out.println("image resized");

        BufferedImage qr_code_buffered = ImageIO.read(new File(DIR_CB_SCRIVI));
        Graphics g = qr_code_buffered.createGraphics();
        g.dispose();

        BufferedImage qr_code_righe = new BufferedImage(250, 250, BufferedImage.TYPE_4BYTE_ABGR);
        g = qr_code_righe.createGraphics();
        for (int i=0; i<25; i++){
            g.drawImage(qr_code_buffered, i*10,0, null);
        }
        g.dispose();
        ImageIO.write(qr_code_righe, "png", new File(DIR_CB_SCRIVI));
        System.out.println("image duplicated");
    }

    public static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }

    /*
    public static BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha)
    {
        System.out.println("resizing...");
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

     */
}
