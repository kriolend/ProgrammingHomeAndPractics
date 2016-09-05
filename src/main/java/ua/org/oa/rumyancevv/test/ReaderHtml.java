package ua.org.oa.rumyancevv.test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by u0100 on 02.07.2016.
 */
public class ReaderHtml {

    static void parseTelephone() throws MalformedURLException {
        List<Telephone> telephoneList = new ArrayList<>();
        String s = null;

        BufferedReader reader = null;
        URL url = new URL("http://olx.ua/obyavlenie/pochasovo-saltovka-novye-doma-holodnaya-gora-IDiFqYc.html#dddea08ac8");
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String html = null;
        try {
            while ((html = reader.readLine()) != null) {
                builder.append(html).append(System.getProperty(System.getProperty("line.separator")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern pattern = Pattern.compile("\\{'path':'phone', 'id':'(\\w+)',");
        Matcher matcher = pattern.matcher(builder.toString());
        while (matcher.find()){
            s = matcher.group(1);
            telephoneList.add(new Telephone(matcher.group()));
            
        }
        System.out.println(s);
    }
}
