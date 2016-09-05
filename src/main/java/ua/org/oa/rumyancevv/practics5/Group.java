package ua.org.oa.rumyancevv.practics5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vr on 19.02.16.
 */
public class Group {

    public static void wR() {
        List<Studet> studets = new ArrayList<>();
        try {
            try(ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream(new File("/home/vr/Документы/1.txt")))){
                fos.writeObject(new Studet("Vasia", 23));
                fos.writeObject(new Studet("Kolya", 25));
                fos.writeObject(new Studet("Oksana", 20));
                fos.flush();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try(ObjectInputStream fis = new ObjectInputStream(new FileInputStream(new File("/home/vr/Документы/1.txt")))){
                try {
                    System.out.println(fis.readObject());
                    System.out.println(fis.readObject());
                    System.out.println(fis.readObject());
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

