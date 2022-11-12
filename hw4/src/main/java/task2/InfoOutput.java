package task2;

public class InfoOutput {

    private final Brain brain;

    public InfoOutput(Brain brain){
        this.brain = brain;
    }

    public void printWords() {
        System.out.println("Short words:");
        for (int i = 0; i < brain.shortWords.size(); i++){
            System.out.println(brain.get(i));
        }
    }
}
