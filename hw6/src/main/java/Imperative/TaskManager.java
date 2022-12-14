package Imperative;

import java.time.LocalDate;
import java.util.*;

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
        tasks.sort(new Comparator<>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getStartsOn().compareTo(o2.getStartsOn());
            }
        });

        List<Task> fiveNearestImportantTasks = new ArrayList<>();
        for (Task task : tasks) {
            if ((task.getStartsOn().isEqual(LocalDate.now()) || task.getStartsOn().isAfter(LocalDate.now())) && task.getType() == TaskType.IMPORTANT && !task.getDone()) {
                fiveNearestImportantTasks.add(task);
            }
            if (fiveNearestImportantTasks.size() == 5) {
                break;
            }
        }

        return fiveNearestImportantTasks;
    }

    public List<String> getUniqueCategories(){
        List<String> categories = new ArrayList<>();
        for (Task task : tasks) {
            categories.add(task.getCategories());
        }

        Set<String> uniqueCategoriesSet = new HashSet<>(categories);

        return new ArrayList<>(uniqueCategoriesSet);
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
    }

    public boolean existsTaskOfCategory(){
        boolean hasCategoryAnyTasks = false;
        for (Task task : tasks) {
            if (task.getCategories().contains(category) && task.getTitle() != null && !task.getDone()) {
                hasCategoryAnyTasks = true;
                break;
            }
        }
        return hasCategoryAnyTasks;
    }

    String getTitlesOfTasks(){
        List<String> titlesOfTasks = new ArrayList<>();
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
        List<String> categories = new ArrayList<>();
        for (Task task : tasks) {
            categories.add(task.getCategories());
        }
        Set<String> uniqueCategoriesSet = new HashSet<>(categories);
        List<String> uniqueCategoriesList = new ArrayList<>(uniqueCategoriesSet);

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

    Task findTaskWithBiggestCountOfCategories(){
        int categoryMax = tasks.get(0).getCategories().length();
        int indexCategoryMax = 0;
        for (int i = 1; i < tasks.size(); i++){
            if (tasks.get(i).getCategories().length() > categoryMax){
                categoryMax = tasks.get(i).getCategories().length();
                indexCategoryMax = i;
            }
        }
        return tasks.get(indexCategoryMax);
    }

    }
