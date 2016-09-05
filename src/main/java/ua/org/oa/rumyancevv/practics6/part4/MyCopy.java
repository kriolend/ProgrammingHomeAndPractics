package ua.org.oa.rumyancevv.practics6.part4;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by user on 27.02.2016.
 */
public class MyCopy extends SimpleFileVisitor<Path>{
    private Path source, distantion;

    public MyCopy(Path source, Path distantion) {
        this.source = source;
        this.distantion = distantion;
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
        Path newDist = distantion.resolve(source.relativize(path));
        new Thread(() -> {
            try {
                Files.copy(path, newDist, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
        Path newDist = distantion.resolve(source.relativize(path));
        try {
            Files.copy(path, newDist, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
