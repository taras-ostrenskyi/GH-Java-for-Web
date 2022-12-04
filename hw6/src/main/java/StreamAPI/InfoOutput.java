package StreamAPI;

import java.util.List;
import java.util.Map;

public class InfoOutput {
    List<Task> tasks;
    Map<String, List<Task>> categoriesMap;
    boolean hasCategoryAnyTasks;
    String titlesOfTasks;
    Task task;

    public InfoOutput(List<Task> tasks){
        this.tasks = tasks;
    }

    public InfoOutput(){

    }

    public InfoOutput(Map<String, List<Task>> categoriesMap){
        this.categoriesMap = categoriesMap;
    }

    public InfoOutput(boolean hasCategoryAnyTasks){
        this.hasCategoryAnyTasks = hasCategoryAnyTasks;
    }

    public InfoOutput(String titlesOfTasks){
        this.titlesOfTasks = titlesOfTasks;
    }
    public InfoOutput(Task task){this.task = task;}

    public void printTaskList() {
        System.out.println("        5 important undone tasks closest to current date:");
        for (Task task : tasks) {
            System.out.println("id:" + task.getId() + " type:" + task.getType() + " title:" + task.getTitle() + " done:" + task.getDone() + " category:" + task.getCategories() + " startsOn:" + task.getStartsOn());
        }
        System.out.println();
    }

    public void printStringList(List<String> stringList){
        System.out.println("        List of all unique categories from all tasks:");
        stringList
                .forEach(System.out::println);
        System.out.println();
    }

    public void printCategoriesMap(){
        System.out.println("        Transformed list of tasks into categories map:");
        for (String keys : categoriesMap.keySet())
        {
            System.out.println(keys + ":");
            for (Task task : categoriesMap.get(keys)) {
                if (task.getCategories().contains(keys)) {
                    System.out.println("id:" + task.getId() + " type:" + task.getType() + " title:" + task.getTitle() + " done:" + task.getDone() + " category:" + task.getCategories() + " startsOn:" + task.getStartsOn());
                }
            }
        }
        System.out.println();
    }

    public void printBooleanMap(Map<Boolean, List<Task>> booleanMap){
        System.out.println("        Map with two lists of done and uncompleted tasks:");
        for (Boolean keys : booleanMap.keySet())
        {
            System.out.println(keys + ":");
            for (Task task : booleanMap.get(keys)) {
                if (task.getDone()==keys) {
                    System.out.println("id:" + task.getId() + " type:" + task.getType() + " title:" + task.getTitle() + " done:" + task.getDone() + " category:" + task.getCategories() + " startsOn:" + task.getStartsOn());
                }
            }
        }
        System.out.println();
    }

    public void printHasCategoryAnyTasksOrNot(){
        System.out.println("        Search whether the category has any tasks or not:");
        if (hasCategoryAnyTasks){
            System.out.println("There are tasks in this category");
        }
        else{
            System.out.println("There are NO tasks in this category");
        }
        System.out.println();
    }

    public void printTitlesOfTasks(){
        System.out.println("        Titles of some tasks range joined by comma:");
        System.out.println(titlesOfTasks);
        System.out.println();
    }

    public void printCountsByCategories(Map<String, Long> countsByCategories){
        System.out.println("        Сount of tasks in each category:");
        for (String keys : countsByCategories.keySet()){
            System.out.println(keys + ": " + countsByCategories.get(keys));
        }
        System.out.println();
    }

    public void printTask() {
        System.out.println("        Task that has longest category:");
        System.out.println("id:" + task.getId() + " type:" + task.getType() + " title:" + task.getTitle() + " done:" + task.getDone() + " category:" + task.getCategories() + " startsOn:" + task.getStartsOn());
        System.out.println();
    }

}
