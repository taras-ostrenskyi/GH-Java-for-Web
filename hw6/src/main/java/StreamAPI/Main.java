package StreamAPI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, TaskType.CURRENT, "Meet Ruslan", true, "Official meeting", LocalDate.of(2022, 10,1)));
        tasks.add(new Task(2, TaskType.MEDIUM, "Clean the house", true, "Homework", LocalDate.of(2022, 11,2)));
        tasks.add(new Task(3, TaskType.IMPORTANT, "Meet Ivan", false, "Official meeting", LocalDate.of(2022, 12,25)));
        tasks.add(new Task(4, TaskType.IMPORTANT, "Meet Oksana", false, "Unofficial meeting", LocalDate.of(2022, 12,26)));
        tasks.add(new Task(5, TaskType.IMPORTANT, "Meet Oksana", false, "Unofficial meeting", LocalDate.of(2022, 12,28)));
        tasks.add(new Task(6, TaskType.CURRENT, "Make Olivier salad without mayonnaise", false, "Homework", LocalDate.of(2022, 12,30)));
        tasks.add(new Task(7, TaskType.IMPORTANT, "Read \"Сlean code\"", false, "Homework", LocalDate.of(2022, 12,31)));
        tasks.add(new Task(8, TaskType.IMPORTANT, "Write a letter to Santa Claus", false, "Working with dreams", LocalDate.of(2022, 12,29)));
        tasks.add(new Task(9, TaskType.MEDIUM, "Meet Viktor", false, "Official meeting", LocalDate.of(2022, 12,27)));
        tasks.add(new Task(10, TaskType.IMPORTANT, "To visit my mother", false, "Official meeting", LocalDate.of(2023, 1,2)));
        tasks.add(new Task(11, TaskType.IMPORTANT, "Go to the bathhouse", false, "Unofficial meeting", LocalDate.of(2023, 1,1)));

        new InfoOutput(new TaskManager(tasks).find5NearestImportantTasks()).printTaskList();

        new InfoOutput().printStringList(new TaskManager(tasks).getUniqueCategories());

        new InfoOutput(new TaskManager(tasks).getCategoriesWithTasks()).printCategoriesMap();

        new InfoOutput().printBooleanMap(new TaskManager(tasks).splitTasksIntoDoneAndInProgress());

        new InfoOutput(new TaskManager(tasks, "There is no such category").existsTaskOfCategory()).printHasCategoryAnyTasksOrNot();
        new InfoOutput(new TaskManager(tasks, "Homework").existsTaskOfCategory()).printHasCategoryAnyTasksOrNot();

        new InfoOutput(new TaskManager(tasks, 2, 4).getTitlesOfTasks()).printTitlesOfTasks();

        new InfoOutput().printCountsByCategories(new TaskManager().getCountsByCategories(tasks));

        new InfoOutput(new TaskManager(tasks).findTaskWithBiggestCountOfCategories()).printTask();

    }

}
