import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
        BufferedImage img, newImg;

        for (int i = 0; i < numberOfFiles; i++) {
            f = listOfFiles[i];
            fName = f.getName();
            sfName = "Kopia_"+fName;
            if (fName.toUpperCase().endsWith(".JPG")) {
                System.out.println(listOfFiles[i].getName() + " " + listOfFiles[i].length());



                try {

                    img = ImageIO.read(f);
                    sf = new File("F:\\Zdjęcia\\test\\" + sfName);

                    newImg = new BufferedImage(100,75, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = newImg.createGraphics();
//                    AffineTransform at = AffineTransform.getScaleInstance(
//                            (double) 100/img.getWidth(), (double) 75/img.getHeight());
//                    g.drawRenderedImage(img, at);
                    g.drawImage(img, 0,0, 100, 75, null);
                    g.dispose();

                    ImageIO.write(newImg, "jpg", sf);


                    System.out.println("Width : " + img.getWidth());
                    System.out.println("Height: " + img.getHeight());
                    System.out.println();
                    } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   }
}
