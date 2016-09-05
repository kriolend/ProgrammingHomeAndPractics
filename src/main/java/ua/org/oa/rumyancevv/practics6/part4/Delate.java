package ua.org.oa.rumyancevv.practics6.part4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 27.02.2016.
 */
public class Delate {
    public static void main(String[] args) {
        String source = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter dir delate");
            source = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path pathSource = Paths.get(source);
        try {
            Files.delete(pathSource);
            System.out.println("File deleted successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
