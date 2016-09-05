package ua.org.oa.rumyancevv.homeTask2.regularExpressions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 24.01.2016.
 */
public class parserMarckdown {

    static void pase() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/home/vr/IdeaProjects/ProgrammingPTJANXVI/src/main/resources/parse.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;

        List<String> lines = new ArrayList<String>();
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains("#")) {
                    Pattern pattern = Pattern.compile("#{1,1}(\\w+\\s\\w+)[\\s\\S]*?");
                    Matcher matcher = pattern.matcher(line);
                    String newStr = matcher.replaceAll("<h1>$1</h1>");
                    lines.add(newStr);
                }

                if (line.contains("##")) {
                    Pattern pattern = Pattern.compile("#{2,2}(\\w+\\s\\w+)[\\s\\S]*?");
                    Matcher matcher = pattern.matcher(line);
                    String newStr = matcher.replaceAll("<h2>$1</h2>");
                    lines.add(newStr);
                }


                if (line.contains("*")) {
                    Pattern pattern = Pattern.compile("[\\*]([\\s\\S]*?)[\\*][\\s\\S]*?");
                    Matcher matcher = pattern.matcher(line);
                    String newStr = matcher.replaceAll("<em>$1<em>");
                    lines.add(newStr);
                } else
                if (line.contains("*")) {
                    Pattern pattern = Pattern.compile("[\\*\\*]([\\s\\S]*?)[\\*\\*][\\s\\S]*?");
                    Matcher matcher = pattern.matcher(line);
                    String newStr = matcher.replaceAll("<strong>$1</strong>");
                    lines.add(newStr);
                }
                if (line.contains("[")) {
                    Pattern pattern = Pattern.compile("[\\[]([\\s\\S]*?[\\]])[\\s\\S]*?[\\(]([\\s\\S]*?)[\\)][\\s\\S]*?");
                    Matcher matcher = pattern.matcher(line);
                    String newStr = matcher.replaceAll("<a href=“$2“>$1</a>");
                    lines.add(newStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : lines){
            System.out.println(s);
        }

    }

}
