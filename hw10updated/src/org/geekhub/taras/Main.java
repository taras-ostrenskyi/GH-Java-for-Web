package org.geekhub.taras;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    private static final int MAX_IMAGES = 200;
    private static final String URL = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=";

    public static void main(String[] args) {
        File imagesDirectory = new File("C:\\OutputFiles for hw10");
        boolean created = imagesDirectory.mkdir();
        if (!created) {
            return;
        }

        ImageCrawler imageCrawler = new ImageCrawler(imagesDirectory);

        int page = 1;
        int downloaded = 0;
        while (downloaded <= 200) {
            downloaded += imageCrawler.download(MAX_IMAGES - downloaded, URL + page);
            page += 1;
        }

        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

