package workwithfiles.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeCopy {
    public static void main(String[] args) throws IOException {
        Path source = Paths.get("/Users/roofflex/Programming/Test");
        Path target = Paths.get("/Users/roofflex/Programming/Copied");

        Files.walkFileTree(source, new MySimpleFileVisitor(source, target));

    }

}

class MySimpleFileVisitor extends SimpleFileVisitor<Path>{

    Path source;
    Path target;

    public MySimpleFileVisitor(Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newTarget = target.resolve(source.relativize(file));
        Files.copy(file, newTarget);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newTarget = target.resolve(source.relativize(dir));
        Files.copy(dir, newTarget);
        return FileVisitResult.CONTINUE;
    }
}