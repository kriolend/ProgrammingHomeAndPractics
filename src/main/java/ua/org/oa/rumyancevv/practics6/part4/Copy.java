package ua.org.oa.rumyancevv.practics6.part4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by user on 23.02.2016.
 */
public class Copy implements Runnable{
    private File sourceDir;
    private String source;
    private String distatantion;

    public Copy(File sourceDir, String source, String distatantion) {
        setSourceDir(sourceDir);
        setSource(source);
        setDistatantion(distatantion);
        try {
            Files.createDirectory(Paths.get(sourceDir.getAbsolutePath().replace(source, distatantion)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(File sourceDir) {
        this.sourceDir = sourceDir;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDistatantion() {
        return distatantion;
    }

    public void setDistatantion(String distatantion) {
        this.distatantion = distatantion;
    }

    @Override
    public void run() {
        for (File file : getSourceDir().listFiles()) {
            if(file.isDirectory()) {
                Thread finder = new Thread(new Copy(file, getSource(), getDistatantion()));
                finder.start();
            } else {
                Path dstantionPath = Paths.get(file.getAbsolutePath().replace(getSource(), getDistatantion()));
                try {
                    Files.copy(file.toPath(), dstantionPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
