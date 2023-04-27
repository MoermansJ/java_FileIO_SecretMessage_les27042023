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
        //creating directory
        Path filePath = Paths.get("resources/Secret Folder/");
        try {
            if (!filePath.toFile().exists()) {
                Files.createDirectories(filePath);
            }
        } catch (IOException e) {
            System.out.println("An exception occurred when creating the directories\n" + e.getMessage());
            e.printStackTrace();
        }

        //creating + writing text to file SECRET MESSAGE.TXT
        String message = "The wolf is in the pig pen. I repeat: the wolf is in the pig pen.";
        Path fileName = filePath.resolve("Secret Message.txt");

        try (FileWriter fileWriter = new FileWriter(fileName.toFile());
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(message);
        } catch (IOException e) {
            System.out.println("An exception occurred when writing to the file\n" + e.getMessage());
            e.printStackTrace();
        }

        //creating + writing image to IMAGE.JPG
        Path imageName = filePath.resolve("Secret Picture.jpg");
        try {
            BufferedImage image = ImageIO.read(new URL("https://worldstories.org.uk/content/book/262/__picture_9352.jpg"));
            ImageIO.write(image, "jpg", imageName.toFile());
        } catch (IOException e) {
            System.out.println("An exception occurred when handling the image\n" + e.getMessage());
            e.printStackTrace();
        }

    }
}
