package org.geekhub.taras;

import java.io.*;
import java.net.URL;

public class ImagesDownloader implements Runnable {
    private final String imageURL;
    private final File directory;

    public ImagesDownloader(String imageURL, File directory) {
        this.imageURL = imageURL;
        this.directory = directory;
    }

    @Override
    public void run() {
        String imageName = imageURL.substring(imageURL.lastIndexOf("/") + 1);
        String imageNameShort = imageName.substring(0, imageName.lastIndexOf(".") + 4);

        try (
                InputStream in = new URL(imageURL).openStream();
                OutputStream os = new FileOutputStream(directory + "\\" + imageNameShort);
        ) {
            byte[] buffer = new byte[4096];
            int n;
            while ((n = in.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
