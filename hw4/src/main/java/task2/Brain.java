package task2;

import java.util.ArrayList;
import java.util.List;

public class Brain {

    public Brain(){

    }

    List<String> shortWords = new ArrayList<String>();

    public void shortenWord(String word){
        String shortWord = "";
        if (word.length() > 10){
            String middleShortWord = Integer.toString(word.length() - 2);
            shortWord = word.charAt(0) + middleShortWord + word.charAt(word.length() - 1);
        }
        else{
            shortWord = word;
        }
        shortWords.add(shortWord);
    }

    public void printShortWords(){
        for (int i = 0; i < shortWords.size(); i++){
            System.out.println(shortWords.get(i));
        }
    }
}
