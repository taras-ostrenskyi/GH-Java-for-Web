package org.geekhub.taras;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ImageCrawler {
    private ExecutorService executorService;

    private final File directory;

    public ImageCrawler(File outputDirectory) {
        this.directory = outputDirectory;
    }

    public int download(int maxImages, String sourceURL) {
        int downloaded = 0;

        while (downloaded <= maxImages) {
            Document document;
            try {
                document = Jsoup.connect(sourceURL).get();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Elements imageElements = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            if (imageElements.isEmpty()) {
                continue;
            }

            for (int i = 0; i < imageElements.size(); i++) {
                String imageURL = imageElements.get(i).attr("src");
                Future<?> submit = executorService.submit(new ImagesDownloader(imageURL, directory));

                downloaded += 1;

                if (downloaded >= maxImages) {
                    break;
                }
            }
        }
        return downloaded;
    }
}
