package ua.org.oa.rumyancevv.homeTask2.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 03.02.2016.
 */
public class parsersMarcDown {

    public static String buelderReader(String s){

        StringBuilder builder = new StringBuilder().append("<html>").append("\n").append("<body>").append("\n");

        String[] arrayString = s.split("\n");

        String voidArray = arrayString[0];

        Pattern pattern = Pattern.compile("\\#+");
        Matcher matcher = pattern.matcher(voidArray);
        if (matcher.find()) {
            int symbol = matcher.group().length();
            voidArray = matcher.replaceAll("<h" + symbol + ">");
            builder.append(voidArray).append("</h" + symbol + ">").append("\n");
        }

        for (int i = 1; i < arrayString.length; i++) {

            String line = arrayString[i];

            line = mphasi(line);
            line = strong(line);
            line = link(line);

            builder.append("<p>").append(line).append("</p>").append("\n");

        }
        builder.append("</html>").append("\n").append("</body>");

        return builder.toString();

    }

    public static String mphasi (String s){
        Pattern pattern1 = Pattern.compile("\\s\\*{1}(\\w+)\\*{1}\\s");
        Matcher matcher1 = pattern1.matcher(s);
        s = matcher1.replaceAll(" <em>$1</em> ");

        return s;
    }

    public static String strong(String s) {
        Pattern pattern2 = Pattern.compile("\\s\\*{2}(\\w+)\\*{2}\\s");
        Matcher matcher2 = pattern2.matcher(s);
        s = matcher2.replaceAll(" <strong>$1</strong> ");

        return s;
    }

    public static String link(String s) {
        Pattern pattern3 = Pattern.compile("\\s\\[(.+)\\]\\((.+)\\)");
        Matcher matcher3 = pattern3.matcher(s);
        s = matcher3.replaceAll(" <a href=“$2“>$1</a> ");

        return s;
    }


}
