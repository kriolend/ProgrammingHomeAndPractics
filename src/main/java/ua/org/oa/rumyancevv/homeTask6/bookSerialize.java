package ua.org.oa.rumyancevv.homeTask6;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by vr on 19.02.16.
 */
public class bookSerialize implements Serializable{
    ArrayList<Book> books = new ArrayList<>();
    public static void readFile(){
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new File("/home/vr/Документы/translite/2.txt")));

    }

    public static void desir() {
        try {
            try(ObjectInputStream fis = new ObjectInputStream(new FileInputStream("/home/vr/Документы/translite/2.txt"))){
                try {
                    ArrayList<Book> books = (ArrayList<Book>) fis.readObject();
                    for (Book book : books) {
                        System.out.println(book.toString());

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

