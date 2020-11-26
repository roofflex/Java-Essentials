package workwithfiles.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFIleTreeDelete {
    public static void main(String[] args) throws IOException {
        Path target = Paths.get("/Users/roofflex/Programming/Copied");

        Files.walkFileTree(target, new MySimpleFileVisitor2());
    }
}

class MySimpleFileVisitor2 extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Files.delete(dir);
        return FileVisitResult.CONTINUE;
    }
}
