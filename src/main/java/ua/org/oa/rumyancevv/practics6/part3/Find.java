package ua.org.oa.rumyancevv.practics6.part3;

import java.io.*;

/**
 * Created by user on 23.02.2016.
 */
public class Find implements Runnable {
    private File dirPatch;
    private Writer writer;

    public Find(File dirPatch, Writer writer) {
        setDirPatch(dirPatch);
        setWriter((BufferedWriter) writer);
    }

    public File getDirPatch() {
        return dirPatch;
    }

    public void setDirPatch(File dirPatch) {
        this.dirPatch = dirPatch;
    }

    public BufferedWriter getWriter() {
        return (BufferedWriter) writer;
    }

    public void setWriter(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        for (File entry : getDirPatch().listFiles()) {
            if (entry.isDirectory()) {
                Thread thread = new Thread(new Find(entry, getWriter()));
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            if (entry.isFile() && entry.getName().toLowerCase().endsWith(".txt")) {
                writer(entry.getAbsolutePath());
            }
        }
    }
    public void writer(String patchLog) {
        try {
            getWriter().write(patchLog);
            getWriter().newLine();
            getWriter().flush();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}





