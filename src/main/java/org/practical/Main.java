package org.practical;

import org.practical.DAO.TaskDAO;
import org.practical.DAO.TaskDAOInterface;
import org.practical.DTO.Task;
import org.practical.Exceptions.DAOException;
import org.practical.Menu.SystemMenu;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemMenu menu = new SystemMenu();
        Scanner sc = new Scanner(System.in);
        int userOption;

        try {
            menu.displayMenu();
            userOption = sc.nextInt();

            switch (userOption) {
                case 1:
                    addNewTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    displayTaskByTag();
                    break;
                default:
                    displayAllTasks();
            }

        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllTasks() {
        TaskDAOInterface ITaskDao = new TaskDAO();

        System.out.println("\nDisplay all tasks: ");
        List<Task> tasks = ITaskDao.findAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("There are no tasks do display");
            System.exit(1);
        }

        for (Task taskItem : tasks) {
            System.out.println("Task: " + taskItem.toString());
        }
    }

    public static void addNewTask() {
        TaskDAOInterface ITaskDao = new TaskDAO();
        Scanner insert = new Scanner(System.in);
        String title, tag, due_date;

        System.out.println("\nPlease, insert the new task title: ");
        title = insert.nextLine();

        System.out.println("\nPlease, insert a new tag: ");
        tag = insert.nextLine();

        System.out.println("\nPlease, insert the due date for this task: ");
        due_date = insert.nextLine();

        ITaskDao.addNewTask(title, tag, due_date);
    }

    public static void deleteTask() {
        TaskDAOInterface ITaskDao = new TaskDAO();
        Scanner delete = new Scanner(System.in);
        int task_id_input;

        System.out.println("\nPlease, enter the task id you want to delete: ");
        task_id_input = delete.nextInt();

        ITaskDao.deleteTask(task_id_input);
    }

    public static void displayTaskByTag() {
        TaskDAOInterface ITaskDao = new TaskDAO();
        Scanner search = new Scanner(System.in);
        String userSearch;

        System.out.println("\nPlease, insert the tag of the task you want to search for: ");
        userSearch = search.nextLine();

        System.out.println(ITaskDao.findAllTasksByTag(userSearch));
    }
}