package Imperative;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Task {
    private final int id;
    private final TaskType type;
    private final String title;
    private final boolean done;
    private final Set<String> categories;
    private final LocalDate startsOn;

    public Task(int id, TaskType type, String title, boolean done, String category, LocalDate startsOn){
        this.id = id;
        this.type = type;
        this.title = title;
        this.done = done;
        this.categories = new HashSet<>();
        categories.add(category);
        this.startsOn = startsOn;
    }

    public int getId(){
        return id;
    }

    public TaskType getType(){
        return type;
    }

    public String getTitle(){
        return title;
    }

    public boolean getDone(){
        return done;
    }
    public String getCategories(){
        return categories.toString();
    }
    public LocalDate getStartsOn(){
        return startsOn;
    }

}
