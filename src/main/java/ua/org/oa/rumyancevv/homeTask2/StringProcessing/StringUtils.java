package ua.org.oa.rumyancevv.homeTask2.StringProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 23.01.2016.
 */
public class StringUtils {

    static String reverse() {
        String string = "Hello world!";
        System.out.println(string);
        String s = new StringBuffer(string).reverse().toString();
        System.out.println(s);

        return s;
    }

    static void polindrom() {
        System.out.println("------------------------------------------");
        String string1 = "А роза упала на лапу Азора";
        String sp = string1.replaceAll(" ", "").toLowerCase();
        System.out.println(string1);
        String d = new StringBuffer(string1).reverse().toString();
        String b = d.replaceAll(" ", "").toLowerCase();
        if (sp.equals(b)) {
            System.out.println("Tru");
        } else
            System.out.println("False");
    }

    static void sizeString() {
        System.out.println("--------------------------------------------");
        String s = "qht";
        String s1 = "";
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.length() > 10) {
                s1 = s.substring(0, 6);
            } else {
                String b = "";
                int lenght = 12 - s.length();
                for (int j = 0; j < lenght; j++) {
                    b += "o";
                }
                s1 = s + b;
            }

        }
        System.out.println(s1);

    }
    static void replaceWord() {
        System.out.println("-------------------------------------------------");
        List<String> stringList = new ArrayList<>();
        List<String> text = new ArrayList<>();
        text.add("opa opa opapa");
        String str = null;
        StringTokenizer st = null;
        for (String z : text){
            System.out.println(z);
            st = new StringTokenizer(z, " ,:;");
            while (st.hasMoreTokens()){
                str = st.nextToken();
                stringList.add(str);
            }
            String temp = stringList.get(0);
            int lastIndex = stringList.size() - 1;
            String lastWord = stringList.get(lastIndex);
            stringList.set(0, lastWord);
            stringList.set(lastIndex, temp);
            for (String i : stringList) {
                System.out.print(i.concat(" "));
            }
        }
    }
    static void replaceWordAllText() {
        System.out.println("---------------------------------------------");
        System.out.println();
        String str = null;
        List<String> stringList = new ArrayList<>();
        List<String> text = new ArrayList<>();
        String wordText = "111 222 333.444 555 666.777 888 999.";
        StringTokenizer st = null;

        st = new StringTokenizer(wordText, ".");
        while (st.hasMoreTokens()) {
            str = st.nextToken();
            text.add(new String(str));
        }

        for (String s : text){
            System.out.println(s);
        }


        String str1 = null;
        StringTokenizer st1 = null;
        for (String z : text) {
                st1 = new StringTokenizer(z, " ");
                while (st1.hasMoreTokens()) {
                    str1 = st1.nextToken();
                    stringList.add(new String(str1));
                }


                String temp = stringList.get(0);
                int lastIndex = stringList.size() - 1;
                String lastWord = stringList.get(lastIndex);
                stringList.set(0, lastWord);
                stringList.set(lastIndex, temp);
                for (String i : stringList) {
                    System.out.print(i.concat(" "));
                }

        }
        System.out.println();

    }
    static void stringIn(){
        System.out.println("----------------------------------------------------");
        String str = "ahkbc";
        Pattern pattern = Pattern.compile("^abc$");
        Matcher matcher =pattern.matcher(str);
        boolean result = matcher.matches();
        System.out.println(result);

    }
    static void isDate() {
        System.out.println("--------------------------------------------------");
        String str = "19.09.2010";
        Pattern pattern = Pattern.compile("^(0[1-9]|[12]\\d|3[01]).([0][1-9]|1[0-2]).((?:1[6-9]|[2-9]\\d)\\d{2})$");
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        System.out.println(result);

    }
    static void isEmail(){
        System.out.println("------------------------------------------------------");
        String str = "asd@rt.com";
        Pattern pattern = Pattern.compile("^(\\w+)@(\\w+\\.)(\\w+)(\\.\\w+)*$");
        Matcher matcher = pattern.matcher(str);
        boolean result = matcher.matches();
        System.out.println(result);
    }
    static void isPhone(){
        System.out.println("-----------------------------------------------------");
        String str = "ddfjk +3(8068)123-33-33, aksd +3(876)333-33-33 sad +5(456)667-77-77";
        Pattern pattern = Pattern.compile("\\+[0-9]{1}\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}");
        Matcher matcher = pattern.matcher(str);
        String phone = new String();
        StringBuilder count = new StringBuilder();
        int i=0;
        while(matcher.find()){
            count.append(matcher.group() + "\n");
        }
        phone = count.toString();
        System.out.println(phone);
    }

}

