package org.practical.DAO;

import org.practical.DTO.Task;
import org.practical.Exceptions.DAOException;

import java.util.List;

public interface TaskDAOInterface {

    public List<Task> findAllTasks() throws DAOException;

    public List<Task> findAllTasksByTag(String tag) throws DAOException;

    public void addNewTask(String title, String tag, String due_date) throws DAOException;

    public void deleteTask(int task_id) throws DAOException;
}
