import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class Main {

    public static final String DIR_AR = "src/shide.jpg";
    public static final String DIR_IEE = "src/header_ieee.jpg";

    public static void main(String[] args) throws IOException {

        File fi_ar = new File(DIR_AR);
        byte[] fileContent_ar = Files.readAllBytes(fi_ar.toPath());
        System.out.println(fileContent_ar.length);

        File fi_ieee = new File(DIR_IEE);
        byte[] fileContent_ieee = Files.readAllBytes(fi_ieee.toPath());
        System.out.println(fileContent_ieee.length);

        int pos = 0;
        int i_ar =0;
        int i_iee = 0;

        while (i_ar < fileContent_ieee.length){
            if(fileContent_ar[i_ar] != fileContent_ieee[i_iee]) pos++;
            i_ar ++;
            i_iee ++;
        }
        byte[] differenti = new byte[pos];
        i_ar = 1275;
        i_iee = 1275;
        pos =0;

        //XOR a casissimo
        while (i_ar <fileContent_ieee.length){
            differenti[pos] = (byte) (fileContent_ieee[i_iee] ^ fileContent_ar[i_ar]);
            pos++;
        }

        System.out.println("");


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
