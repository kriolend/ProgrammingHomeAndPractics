package ua.org.oa.rumyancevv.homeTask2.regularExpressions;

/**
 * Created by user on 23.01.2016.
 */
public class App {
    public static void main(String[] args) {


        String s = "##Header line\n" +
                "Simple line *with* em Simple line *with* em\n" +
                "Simple **line** with strong\n" +
                "Line with link [Link to google](https://www.google.com) in center\n" +
                "Line **with** *many* **elements** and link [Link to FB](https://www.facebook.com)";

        System.out.println(parsersMarcDown.buelderReader(s));
    }
}
