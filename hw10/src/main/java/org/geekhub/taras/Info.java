package org.geekhub.taras;

import java.nio.file.Path;

public class Info {
    private String imageNameShort;
    private String strImageURL;
    private Path fileName;
    private String newFileName;

    public Info(String imageNameShort, String strImageURL){
        this.imageNameShort = imageNameShort;
        this.strImageURL = strImageURL;
    }

    public Info(){

    }

    public Info(Path fileName, String newFileName){
        this.fileName = fileName;
        this.newFileName = newFileName;
    }

    public void printDownloadImageStartInfo(){
        System.out.println("Saving " + imageNameShort + "   from " + strImageURL);
    }

    public void printDownloadImageEndInfo(){
        System.out.println("Image saved");
        System.out.println();
    }

    public void printDownloadEndInfo(){
        System.out.println("Files have been downloaded");
    }

    public void printRenamingInfo(){
        System.out.println();
        System.out.println("File " + fileName);
        System.out.println("renamed to");
        System.out.println(newFileName);
    }

}
