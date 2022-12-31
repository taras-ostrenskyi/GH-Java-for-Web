package org.geekhub.taras;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class ImagesDownloader implements Runnable {
    String sourceUrl;
    String destinationFolder;
    Integer numberOfFiles;

    public ImagesDownloader(String sourceUrl, String destinationFolder, Integer numberOfFiles){
        this.sourceUrl = sourceUrl;
        this.destinationFolder = destinationFolder;
        this.numberOfFiles = numberOfFiles;
    }

    public void run() {

        Document document = null;
        try {
            document = Jsoup.connect(sourceUrl).get();
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        Elements imageElements = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");

        if ((Objects.requireNonNull(new File(destinationFolder).list())).length < numberOfFiles) {
            for (int i = 0; i < imageElements.size(); i++) {
                String strImageURL = imageElements.get(i).attr("src");
                downloadImage(strImageURL);
                if (Objects.requireNonNull(new File(destinationFolder).list()).length >= numberOfFiles) {
                    System.out.println("Number of downloaded files = " + numberOfFiles);
                    break;
                }
            }
        }
        else {
            System.out.println("Number of downloaded files = " + numberOfFiles);
        }

    }

    private void downloadImage(String strImageURL){

        String imageName = strImageURL.substring(strImageURL.lastIndexOf("/") + 1);
        String imageNameShort = imageName.substring(0, imageName.lastIndexOf(".") + 4);

        System.out.println("Saving " + imageNameShort + "   from " + strImageURL);
        try {
            URL urlImage = new URL(strImageURL);
            InputStream in = urlImage.openStream();
            OutputStream os = new FileOutputStream(destinationFolder + "\\" + imageNameShort);

            byte[] buffer = new byte[4096];
            int n = -1;
            while ( (n = in.read(buffer)) != -1 ){
                os.write(buffer, 0, n);
            }

            os.close();
            System.out.println("Image saved");
            System.out.println();
        }
        catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

    }

}
