package ua.org.oa.rumyancevv.homeTask5;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 07.02.2016.
 */
public class translite {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, String> dirMap = new HashMap<>();
    static Map<String, String> transliteMap = new HashMap<>();

    public static void runClass(String dirPatch) {
        int count = 0;
        File f = new File(dirPatch);
        if (f.isDirectory()) {
            for (File item : f.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \tкаталог");
                } else {
                    count++;
                    dirMap.put(count, item.getName());
                    System.out.println(count + " " + item.getName() + "\tфайл");
                }
            }
        }

        try {
            System.out.println("Type a file name with languages:");
            int fileNumber = 0;
            fileNumber = Integer.parseInt(reader.readLine());
            String pathTranslate = dirPatch + "\\" + dirMap.get(fileNumber);
            System.out.println(pathTranslate);
            BufferedReader readerFileMap = new BufferedReader(new FileReader(pathTranslate));
            String line;
            while ((line = readerFileMap.readLine()) != null) {
                Pattern pattern = Pattern.compile("(.+)=(.+)");
                Matcher matcher = pattern.matcher(line.toString());
                while (matcher.find()) {
                    transliteMap.put(matcher.group(1), matcher.group(2));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Input path to file");
        String pathToFle = "";
        try {
            pathToFle = reader.readLine();
            BufferedReader reader1 = new BufferedReader(new FileReader(pathToFle));
            String line = "";
            StringBuilder sbLine = new StringBuilder();
            while ((line = reader1.readLine()) != null) {
                sbLine.append(line);
            }
            String line2 = String.valueOf(sbLine);
            StringBuilder sb = new StringBuilder();
            for (String entry : line2.split(" ")) {
                sb.append(transliteMap.containsKey(entry) ? transliteMap.get(entry) : entry).append(" ");
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
