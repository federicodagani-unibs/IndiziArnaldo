import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class Main {

    public static final String DIR_AR = "src/shide.jpg";
    public static final String DIR_IEE = "src/header_ieee.jpg";
    public static final int DIMENSIONE = 100000;

    public static void main(String[] args) throws IOException {

        BufferedImage img_ar = ImageIO.read(new URL("https://pgarnaldo.com/shide.jpg"));
        BufferedImage img_ieee = ImageIO.read(new URL("https://ieeesb.unibs.it/images/header_ieee.jpg"));



        File fi_ar = new File(DIR_AR);
        byte[] fileContent_ar = Files.readAllBytes(fi_ar.toPath());
        System.out.println(fileContent_ar.length);

        File fi_ieee = new File(DIR_IEE);
        byte[] fileContent_ieee = Files.readAllBytes(fi_ieee.toPath());
        System.out.println(fileContent_ieee.length);

        int pos = 0;
        int i_ar =0;
        int i_iee = 0;
        byte[] differenti = new byte[DIMENSIONE];

        while (i_ar < fileContent_ieee.length){
            if(fileContent_ar[i_ar] != fileContent_ieee[i_iee]){
                /*
                differenti[pos] = fileContent_ar[i_ar];
                System.out.println(differenti[pos] + "  " +i_ar);
                 */
                pos++;
                /*
                while (fileContent_ar[i_ar] != fileContent_ieee[i_iee]){
                    i_iee++;
                }

                 */
            }
            i_ar ++;
            i_iee ++;
        }
        System.out.println(pos);
        /*
        Metadata meta = new Metadata();
        String filename = "src/shide.jpg";
        if (new File(filename).exists()) {
            meta.readAndDisplayMetadata(filename);
        } else {
            System.out.println("cannot find file: " + filename);
        }
        return;

         */
    }
}
