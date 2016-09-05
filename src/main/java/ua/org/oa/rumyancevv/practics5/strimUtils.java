package ua.org.oa.rumyancevv.practics5;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 16.02.2016.
 */
public class strimUtils {
    public static void randomWriter (String patchFile, int randomNumber) {

        Random rand = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(patchFile))) {
            for (int i = 0; i < randomNumber; i++) {
                writer.write(String.valueOf(rand.nextInt(100)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sortedFile(String fileName) {
        List<String> list = new ArrayList<>();
        String s = "";
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while ((s = reader.readLine()) != null) {
                    list.add(s);
                }
                Collections.sort(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String o : list) {
                if (list != null) {
                    writer.write(String.valueOf(o));
                    writer.newLine();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void studentBull(String filePatch) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePatch))) {
                String s = "";
                StringBuilder sb = new StringBuilder();
                while ((s = reader.readLine()) != null) {
                    sb.append(s);
                }
                Pattern pattern = Pattern.compile("(\\w+\\s\\w+) = (\\d+)");
                Matcher matcher = pattern.matcher(sb);
                while (matcher.find()) {
                    if (map.get(matcher.group(1)) != null) {
                        map.get(matcher.group(1)).add(Integer.parseInt(matcher.group(2)));
                    } else {
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(Integer.parseInt(matcher.group(2)));
                        map.put(matcher.group(1), list1);
                    }
                }

                for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    List<Integer> value = entry.getValue();
                    int count = 0;
                    for (int i = 0; i < value.size(); i++) {
                        count = count + value.get(i);
                    }
                    double sred = (double) count / value.size();
                    if (sred >= 90) {
                        System.out.println(key + " " + sred);
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replaceWord(String filePatch) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePatch))) {
            String text = null;
            StringBuilder sb = new StringBuilder();
            while ((text = reader.readLine()) != null) {
                sb.append(text).append('\n');
            }
            reader.close();
            text = sb.toString();
            String[] lineAppend = text.split("[\\!|\\.|\\?]\\s?");
            String[] result = new String[lineAppend.length];
            for (int i = 0; i < lineAppend.length; i++) {
                result[i] = lineAppend[i].trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)", "$3$2$1$4");
            }
            for (String s : result) {
                list.add(s);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePatch));
            for (String o : list) {
                if (list != null) {
                    writer.write(String.valueOf(o));
                    writer.newLine();
                }

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copy(String source, String dest, String dest1) throws IOException {
        long startNoBuf = System.nanoTime();
        String s = null;
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(dest);

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();

        long stopNoBuff = System.nanoTime();
        long resultNoBuff = stopNoBuff - startNoBuf;
        System.out.println("No Bufer" + resultNoBuff);

     long startBuff = System.nanoTime();
        String s2;
        StringBuilder builder = new StringBuilder();
        String s3 = String.valueOf(builder);

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while ((s2 = reader.readLine()) != null) {
                builder.append(s2);
            }
            reader.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(dest1))) {


                writer.write(s3);
                System.out.println(s3);
                writer.close();
        } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        long stopBuff = System.nanoTime();
        long resultBuff = stopBuff - startBuff;
        System.out.println("Buffer" + resultBuff);
    }

    public static void siarezableRW(String flePatch){

    }
}
