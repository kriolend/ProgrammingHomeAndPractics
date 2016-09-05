package ua.org.oa.rumyancevv.practics1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by user on 19.01.2016.
 */
public class PatternReader {

    static void parseNotebook()

    {
        List Notebook = new ArrayList<>();
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream("source.html"),"windows-1251"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found, check patch");
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
        Pattern pattern = Pattern.compile("<tr class=\"item\">[\\s\\S]*?alt=\"([A-Za-z]*?[\\s\\S]*?)\"[\\s\\S]*?" +
                "description\">([A-Za-z]*?[\\s\\S]*?)<br />[\\s\\S]*?price cost\">([0-9]*?) [\\s\\S]*?</tr>");
        Matcher matcher = pattern.matcher(builder.toString());
        while (matcher.find()) {
//            System.out.println(matcher.group(3));
            Notebook.add(new Notebook(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3))));
            System.out.println(Notebook);
        }

    }


}
