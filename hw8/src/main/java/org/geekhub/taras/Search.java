package org.geekhub.taras;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Search  {
    Path path;
    String[] fileExtensions;

    public Search(Path path, String[] fileExtensions){
        this.path = path;
        this.fileExtensions = fileExtensions;
    }

    public List<String> findFiles () {
        if (!Files.isDirectory(path)) {
            System.err.println("The folder  " + path + "  does not exist. " + "Path must be a directory!");
        }

        List<String> result;
        Stream<Path> walk = null;
        try {
            walk = Files.walk(path);
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> isEndWith(f, fileExtensions))
                    .collect(Collectors.toList());

        return result;
    }

    private static boolean isEndWith(String file, String[] fileExtensions) {
        boolean result = false;
        for (String fileExtension : fileExtensions) {
            if (file.endsWith(fileExtension)) {
                result = true;
                break;
            }
        }
        return result;
    }

}
