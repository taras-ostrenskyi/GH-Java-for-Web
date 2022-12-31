package org.geekhub.taras;

public class Main {
    public static void main(String[] args) {

        String sourceUrl1 = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=1";
        String sourceUrl2 = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=2";
        String sourceUrl3 = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=3";
        String sourceUrl4 = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=4";
        String sourceUrl5 = "https://www.gettyimages.com/photos/travel?assettype=image&license=rf&alloweduse=availableforalluses&embeddable=true&family=creative&phrase=travel&sort=best&page=5";
        String destinationFolder = "C:\\OutputFiles for hw10";
        Integer numberOfFiles = 200;

        new Thread(new ImagesDownloader(sourceUrl1, destinationFolder, numberOfFiles)).start();
        new Thread(new ImagesDownloader(sourceUrl2, destinationFolder, numberOfFiles)).start();
        new Thread(new ImagesDownloader(sourceUrl3, destinationFolder, numberOfFiles)).start();
        new Thread(new ImagesDownloader(sourceUrl4, destinationFolder, numberOfFiles)).start();
        new Thread(new ImagesDownloader(sourceUrl5, destinationFolder, numberOfFiles)).start();

        System.out.println("Hello world!");
    }
}