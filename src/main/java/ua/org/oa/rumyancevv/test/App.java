package ua.org.oa.rumyancevv.test;

import java.net.MalformedURLException;

/**
 * Created by u0100 on 02.07.2016.
 */
public class App {
    public static void main(String[] args) {
        try {
            ReaderHtml.parseTelephone();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
