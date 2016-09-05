package ua.org.oa.rumyancevv.practics6.part3;

import java.io.*;

/**
 * Created by user on 23.02.2016.
 */
public class App {
    public static void main(String[] args) {
        String dirPatch = "";
        String patchLog = "D:\\Log.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input patch to dirrectory:");
        try {
            dirPatch = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(patchLog)))){
            Thread threadFind = new Thread(new Find(new File(dirPatch), writer));
            threadFind.start();
            try {
                threadFind.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Patch to log file: " + patchLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
