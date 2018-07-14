import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class ListClass {
    private static String dirPath = "";

    public static void main(String[] args) {
        dirPath = "F:\\Zdjęcia\\Zdjęcia 2018.06.10-2018.06.15";

        File folder = new File(dirPath);

        File[] listOfFiles = folder.listFiles();

        int numberOfFiles = 0;

        if (listOfFiles != null) {
            numberOfFiles = listOfFiles.length;
        } else {
            System.out.println("listOfFile -> NullPointerException");
            System.exit(1);
        }

        File f;
        File sf; // save file
        String fName;
        String sfName;
        BufferedImage img;
        for (int i = 0; i < numberOfFiles; i++) {
            f = listOfFiles[i];
            fName = f.getName();
            sfName = "Kopia_"+fName;
            if (fName.toUpperCase().endsWith(".JPG")) {
                System.out.println(listOfFiles[i].getName() + " " + listOfFiles[i].length());
                try {
                    img = ImageIO.read(f);
                    System.out.println("Width : " + img.getWidth());
                    System.out.println("Height: " + img.getHeight());
                    System.out.println();
                    sf = new File("F:\\Zdjęcia\\test\\" + sfName);
                    ImageIO.write(img, "jpg", sf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   }
}
