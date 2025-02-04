package org.practical.Menu;

public class SystemMenu {
    public void displayMenu() {
        System.out.println("\n" +
                "\n" +
                " _____         _      __  __                                   \n" +
                "|_   _|_ _ ___| | __ |  \\/  | __ _ _ __   __ _  __ _  ___ _ __ \n" +
                "  | |/ _` / __| |/ / | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|\n" +
                "  | | (_| \\__ \\   <  | |  | | (_| | | | | (_| | (_| |  __/ |   \n" +
                "  |_|\\__,_|___/_|\\_\\ |_|  |_|\\__,_|_| |_|\\__,_|\\__, |\\___|_|   \n" +
                "                                               |___/           \n" +
                "\n");

        System.out.println("Please, select an option: \n" +
                "1. Add a new task\n" +
                "2. Delete a task\n" +
                "3. List all task with a particular tag\n");
    }
}
