package org.geekhub.taras;

import java.nio.file.Path;

public class InfoOutput {

    Path path;
    String zipFileName;

    public InfoOutput(Path path, String zipFileName){
        this.path = path;
        this.zipFileName = zipFileName;
    }

    public void printInfo(){
        System.out.println();
        System.out.println(zipFileName + "  is created in  " + path);
    }

}
