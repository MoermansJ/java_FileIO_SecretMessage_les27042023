package be.intecbrussel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) {
        Path filePath = Paths.get("resources/Secret Folder/");
        try {
            //creating directory
            if (!filePath.toFile().exists()) {
                Files.createDirectories(filePath);
            }

            //creating + writing text to file SECRET MESSAGE.TXT
            try (FileWriter fileWriter = new FileWriter(filePath.resolve("Secret Message.txt").toFile());
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("The wolf is in the pig pen. I repeat: the wolf is in the pig pen.");
            }

            //creating + writing image to Secret Picture.jpg
            BufferedImage image = ImageIO.read(new URL("https://worldstories.org.uk/content/book/262/__picture_9352.jpg"));
            ImageIO.write(image, "jpg", filePath.resolve("Secret Picture.jpg").toFile());
        } catch (IOException e) {
            System.out.println("An exception occurred\n" + e.getMessage());
            e.printStackTrace();
        }
    }
}
