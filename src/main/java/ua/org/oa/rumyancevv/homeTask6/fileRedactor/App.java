package ua.org.oa.rumyancevv.homeTask6.fileRedactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 20.02.2016.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirPatch = "";
        System.out.println("Input patch to dirrectory:");
        try {
            dirPatch = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.fileEditor(dirPatch);
    }
}
