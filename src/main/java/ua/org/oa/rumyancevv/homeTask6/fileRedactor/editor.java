package ua.org.oa.rumyancevv.homeTask6.fileRedactor;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 20.02.2016.
 */
public class editor {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, String> dirMap = new HashMap<>();

    public static void fileEditor(String dirPatch) {
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

        System.out.println("Select an action:");
        System.out.println("1. New file.");
        System.out.println("2. Delete a file.");
        System.out.println("3. Rename the file.");



        int cathAction = 0;
        try {
            cathAction = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (cathAction == 1) {
            System.out.println("Input new file name:");
            String newFilename = "";
            try {
                newFilename = reader.readLine();
                String namePatch = f.getPath()+ "\\" + newFilename;
                File f1 = new File(namePatch);
                if (f1.createNewFile()) {
                    System.out.println("File create");
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (cathAction == 2) {
            System.out.println("Enter a file number:");
            int fileNumber = 0;
            try {
                fileNumber = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String dirPathDel = f.getPath() + "\\" + dirMap.get(fileNumber);
            System.out.println(dirPathDel);
            File file = new File(dirPathDel);
            if (file.delete()) {
                System.out.println("File delete");
            } else System.out.println("File not found");
        }

        if (cathAction == 3) {
            System.out.println("Enter a file number:");
            int fileNumber = 0;
            try {
                fileNumber = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String dirPathRename = f.getPath() + "\\" + dirMap.get(fileNumber);
            System.out.println(dirPathRename);
            System.out.println("Input new file name:");
            String newName = dirPatch + "";
            try {
                newName = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            File file = new File(dirPathRename);

                File f1 = new File(f.getPath()+ "\\" + newName);
                    if (file.renameTo(f1)){
                        System.out.println("File " + dirMap.get(fileNumber) + " rename " + newName);
            } else {
                        System.out.println("Фокус не удался.");
                    }
        }


    }

}
