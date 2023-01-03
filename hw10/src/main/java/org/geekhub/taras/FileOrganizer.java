package org.geekhub.taras;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileOrganizer extends Thread {
    String destinationFolder;

    public FileOrganizer(String destinationFolder){
        this.destinationFolder = destinationFolder;
    }

    public void run(){
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            System.err.println("Caught RuntimeException: " + e.getMessage());
        }

        File dir = new File(destinationFolder);
        File[] filesInDir = dir.listFiles();
        for (int i = 0; i < Objects.requireNonNull(filesInDir).length; i++){
            Path fileName = Paths.get(destinationFolder + "\\" + filesInDir[i].getName());
            try {
                Files.move(fileName, fileName.resolveSibling(i + 1 + " " + filesInDir[i].getName()));
            } catch (IOException e) {
                System.err.println("Caught IOException" + e.getMessage());
            }
            new Info(fileName, i + 1 + " " + filesInDir[i].getName()).printRenamingInfo();
        }
    }
}
