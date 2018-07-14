import java.io.File;

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
        String fName;
        for (int i = 0; i < numberOfFiles; i++) {
            f = listOfFiles[i];
            fName = f.getName();
            if (fName.toUpperCase().endsWith(".JPG")) {
                System.out.println(listOfFiles[i].getName() + " " + listOfFiles[i].length());
            }
        }
   }
}
