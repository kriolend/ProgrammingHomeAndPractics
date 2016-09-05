package ua.org.oa.rumyancevv.practics6.part4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 23.02.2016.
 */
public class App {
    public static void main(String[] args) {
        String source = "";
        String distanation = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the path to the directory / file to copy:");
            source = reader.readLine();
            System.out.println("Enter the path where to copy:");
            distanation = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path pathSource = Paths.get(source);
        Path pathDestination = Paths.get(distanation);
        new Thread(() -> {
            try {
                Files.walkFileTree(pathSource, new MyCopy(pathSource, pathDestination));
                System.out.println("Files copied successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
//        final String finalDistanation = distanation;
//        final String finalSource = source;
//        new Thread(() -> { new Copy(new File(finalSource), finalSource, finalDistanation);}).start();

    }
}
