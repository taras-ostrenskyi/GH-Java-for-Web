package org.geekhub.taras;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path folderForSearchFiles = Paths.get("C:\\InputFiles for hw8");

        String[] extensionAudio = {"mp3", "wav", "wma"};
        String[] extensionVideo = {"avi", "mp4", "flv"};
        String[] extensionImage = {"jpeg", "jpg", "gif", "png"};

        List<String> audioList = new Search(folderForSearchFiles, extensionAudio).findFiles();
        List<String> videoList = new Search(folderForSearchFiles, extensionVideo).findFiles();
        List<String> imageList = new Search(folderForSearchFiles, extensionImage).findFiles();

        new ZipFileArchiver(audioList, folderForSearchFiles, "audios.zip").createArchive();
        new ZipFileArchiver(videoList, folderForSearchFiles, "videos.zip").createArchive();
        new ZipFileArchiver(imageList, folderForSearchFiles, "images.zip").createArchive();

    }

}