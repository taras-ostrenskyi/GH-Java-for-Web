package org.geekhub.taras;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileArchiver {

    private final List<String> filesList;
    private final Path path;
    private final String zipFileName;

    public ZipFileArchiver(List<String> filesList, Path path, String zipFileName) {
        this.filesList = filesList;
        this.path = path;
        this.zipFileName = zipFileName;
    }

    public void createArchive() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path + "\\" + zipFileName);
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        }
        ZipOutputStream zipOut = new ZipOutputStream(fileOutputStream);

        for (String s : filesList) {
            File fileToZip = new File(s);
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(fileToZip);
            } catch (FileNotFoundException e) {
                System.err.println("Caught FileNotFoundException: " + e.getMessage());
            }

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            try {
                zipOut.putNextEntry(zipEntry);
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }

            byte[] bytes = new byte[1024];
            int length = 0;
            while (true) {
                try {
                    if (!((length = fileInputStream.read(bytes)) >= 0)) {
                        break;
                    }
                } catch (IOException e) {
                    System.err.println("Caught IOException: " + e.getMessage());
                }
                try {
                    zipOut.write(bytes, 0, length);
                } catch (IOException e) {
                    System.err.println("Caught IOException: " + e.getMessage());
                }
            }

            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.err.println("Caught IOException: " + e.getMessage());
            }
        }

        try {
            zipOut.close();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        try {
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        new InfoOutput(path, zipFileName).printInfo();
    }

}
