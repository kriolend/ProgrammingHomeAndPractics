package ua.org.oa.rumyancevv.homeTask5;

import java.io.*;

/**
 * Created by user on 07.02.2016.
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
        translite.runClass(dirPatch);
    }
}
