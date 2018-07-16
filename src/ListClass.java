// https://www.mkyong.com/java/how-to-resize-an-image-in-java/

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ListClass {
    private static final String SOURCE_PATH = "F:\\Zdjęcia\\Zdjęcia 2018.06.10-2018.06.15\\";
    private static final String DESTINATION_PATH = "F:\\Zdjęcia\\Miniatury\\";
    private static final int IMG_WIDTH = 150;

    public static void main(String[] args) {
        String sourcePath = SOURCE_PATH;
        String destinationPath = DESTINATION_PATH;

        File[] listOfFiles = (new File(sourcePath)).listFiles();

        int numberOfFiles = 0;

        if (listOfFiles != null) {
            numberOfFiles = listOfFiles.length;
        } else {
            System.out.println("listOfFile -> NullPointerException");
            System.exit(1);
        }

        String fName;
        BufferedImage originalImage, resizedImage;

        for (int i = 0; i < numberOfFiles; i++) {
            fName = listOfFiles[i].getName();
            if (fName.toUpperCase().endsWith(".JPG")) {
                System.out.println("Processed " + fName);

                try {
                    originalImage = ImageIO.read(new File(sourcePath+fName));
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
                    resizedImage = resizeImage(originalImage, type);
                    ImageIO.write(resizedImage, "png", new File(destinationPath + "min_" + fName + ".png"));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   }

   private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        int imgWidth = IMG_WIDTH;
        int imgHeight = originalImage.getHeight()*imgWidth/originalImage.getWidth();

        BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight, type);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0,0, imgWidth, imgHeight, null);
        graphics2D.dispose();

        return resizedImage;

   }
}
