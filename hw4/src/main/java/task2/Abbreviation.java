package task2;

import java.util.Scanner;

public class Abbreviation {

    public static void main(String[] args) {
        System.out.println("Please enter integer - a word count, then enter words:");
        Scanner scan = new Scanner(System.in);
        Brain brain = new Brain();
        int wordCount = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= wordCount; i++){
            brain.shortenWord(scan.nextLine());
        }

        InfoOutput infoOutput = new InfoOutput(brain);
        infoOutput.printWords();

    }
}
