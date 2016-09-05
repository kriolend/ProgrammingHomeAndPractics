package ua.org.oa.rumyancevv.homeTask6.booksSerializeble;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vr on 19.02.16.
 */
public class bookSerialize implements Serializable {

    static ArrayList<Book> books = new ArrayList<>();
    public static void readFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\books.txt"))) {
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = reader.readLine()) != null){
                sb.append(s);
            }
            Pattern pattern = Pattern.compile("(\\w+);(\\w+);(\\d+)");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()){
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);
                int group3 = Integer.parseInt(matcher.group(3));
                books.add(new Book(group1, group2, group3));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Book book : books) {
            System.out.println(book);

        }

    }

    public static void serializBook(String filePatch) {
        try{
            FileOutputStream fos= new FileOutputStream(filePatch);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(books);
            oos.close();
            fos.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }


    }
}

