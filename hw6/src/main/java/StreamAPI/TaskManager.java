package StreamAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    List<Task> tasks;
    String category;
    int startNo;
    int endNo;

    public TaskManager(List<Task> tasks){
        this.tasks = tasks;
    }

    public TaskManager(List<Task> tasks, String category){
        this.tasks = tasks;
        this.category = category;
    }

    public TaskManager(){

    }

    public TaskManager(List<Task> tasks, int startNo, int endNo){
        this.tasks = tasks;
        this.startNo = startNo;
        this.endNo = endNo;
    }

    public List<Task> find5NearestImportantTasks(){
        tasks.sort((o1, o2) -> o1.getStartsOn().compareTo(o2.getStartsOn()));

        return tasks.stream()
                .filter(t -> t.getStartsOn().isEqual(LocalDate.now()) || (t.getStartsOn().isAfter(LocalDate.now()) && t.getType() == TaskType.IMPORTANT && !t.getDone()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<String> getUniqueCategories(){
        return tasks.stream()
                .map(Task::getCategories).distinct().collect(Collectors.toList());
    }

    public Map<String, List<Task>> getCategoriesWithTasks(){

        Map<String, List<Task>> categoriesWithTasks = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++){
            categoriesWithTasks.put(tasks.get(i).getCategories(), tasks);
        }
        return categoriesWithTasks;
    }

    public Map<Boolean, List<Task>> splitTasksIntoDoneAndInProgress(){

        Map<Boolean, List<Task>> tasksDoneAndInProgress = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getDone()) {
                tasksDoneAndInProgress.put(tasks.get(i).getDone(), tasks);
            }
            else tasksDoneAndInProgress.put(tasks.get(i).getDone(), tasks);
        }
        return tasksDoneAndInProgress;

        /*return (Map<Boolean, List<Task>>) tasks.stream()
                .filter(p -> p.getDone())
                .map(p -> p.getDone())
                .collect(Collectors.toList());*/
    }

    public boolean existsTaskOfCategory(){
        boolean hasCategoryAnyTasks = false;
        hasCategoryAnyTasks = tasks.stream()
                .anyMatch(t -> t.getCategories().contains(category) && t.getTitle() != null && !t.getDone());
        return hasCategoryAnyTasks;
    }

    String getTitlesOfTasks(){
        List<String> titlesOfTasks = new ArrayList<>();

        /*titlesOfTasks = tasks.stream()
                .map(Task::getTitle)
                .filter( startNo >= tasks.indexOf(tasks.get(0)) + 1 && endNo <= (tasks.indexOf(tasks.get(tasks.size() - 1)) + 1))*/

        if (startNo >= tasks.indexOf(tasks.get(0)) + 1 && endNo <= (tasks.indexOf(tasks.get(tasks.size() - 1)) + 1)){
            for (int i = startNo - 1; i < endNo; i++){
                titlesOfTasks.add(tasks.get(i).getTitle());
            }
        }
        else if (startNo >= tasks.indexOf(tasks.get(0)) + 1 && startNo <= (tasks.indexOf(tasks.get(tasks.size() - 1)) + 1) && endNo >= (tasks.indexOf(tasks.get(tasks.size() - 1)) + 1)){
            for (int i = startNo - 1; i <= tasks.indexOf(tasks.get(tasks.size() - 1)); i++){
                titlesOfTasks.add(tasks.get(i).getTitle());
            }
        }
        else{
            titlesOfTasks.add("Interval is outside the list");
        }
        return String.join(",", titlesOfTasks);
    }

    Map<String, Long> getCountsByCategories(List<Task> tasks){

        List<String> uniqueCategoriesList = tasks.stream()
                .map(Task::getCategories).distinct().collect(Collectors.toList());

        Map<String, Long> countsByCategories = new HashMap<>();
        long count;
        for (String s : uniqueCategoriesList) {
            count = 0;
            for (Task task : tasks) {
                if (task.getCategories().contains(s)) {
                    count++;
                }
            }
            countsByCategories.put(s, count);
        }
        return countsByCategories;
    }

    IntSummaryStatistics getCategoriesNamesLengthStatistics(){
        return tasks.stream()
                .collect(Collectors.summarizingInt(t -> t.getCategories().length()));
    }

    Task findTaskWithBiggestCountOfCategories(){
        int categoryMax = tasks.stream()
                .mapToInt(value -> value.getCategories().length())
                .summaryStatistics()
                .getMax();

        Task taskWithBiggestCountOfCategories = null;
        for (Task task : tasks) {
            if (task.getCategories().length() == categoryMax) {
                taskWithBiggestCountOfCategories = task;
                break;
            }
        }

        return taskWithBiggestCountOfCategories;
    }

}
