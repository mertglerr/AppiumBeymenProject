package Utilities;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    private static String filetext="src/test/java/data/urun-bilgisi.txt";

    public static void writeToFile(String name, String price) {
        try {
            FileWriter writer = new FileWriter(filetext);
            writer.write("Ürün Adı: " + name + "\n");
            writer.write("Ürün Fiyatı: " + price + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
