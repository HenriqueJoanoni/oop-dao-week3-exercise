package org.practical.DAO;

import org.practical.DTO.Task;
import org.practical.Exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class TaskDAO extends DAO implements TaskDAOInterface {

    @Override
    public List<Task> findAllTasks() throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Task> taskList = new ArrayList<>();

        try {
            conn = this.getConn();

            String sql = "SELECT * FROM tasks";
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int task_id = rs.getInt("TASK_ID");
                String title = rs.getString("TITLE");
                String tag = rs.getString("TAG");
                Date due_date = rs.getDate("DUE_DATE");

                Task task = new Task(task_id, title, tag, due_date);
                taskList.add(task);
            }

        } catch (SQLException e) {
            throw new DAOException("findAllTasks() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findAllTasks() " + sqlEx.getMessage());
            }
        }

        return taskList;
    }

    @Override
    public List<Task> findAllTasksByTag(String tag) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Task> taskList = new ArrayList<>();

        try {
            conn = this.getConn();

            String sql = "SELECT * FROM tasks WHERE tag = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, tag);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int task_id = rs.getInt("TASK_ID");
                String title = rs.getString("TITLE");
                String rsTag = rs.getString("TAG");
                Date due_date = rs.getDate("DUE_DATE");

                Task task = new Task(task_id, title, rsTag, due_date);
                taskList.add(task);
            }

        } catch (SQLException e) {
            throw new DAOException("findAllTasks() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("findAllTasks() " + sqlEx.getMessage());
            }
        }

        return taskList;
    }

    @Override
    public void addNewTask(String title, String tag, String due_date) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.getConn();

            String sql = "INSERT INTO tasks (title, tag, due_date) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, tag);
            stmt.setString(3, due_date);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("addNewTask() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("addNewTask() " + sqlEx.getMessage());
            }
        }
    }

    @Override
    public void deleteTask(int task_id) throws DAOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = this.getConn();

            String sql = "DELETE FROM tasks WHERE task_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, task_id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("deleteTask() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    freeConnection(conn);
                }
            } catch (SQLException sqlEx) {
                throw new DAOException("deleteTask() " + sqlEx.getMessage());
            }
        }
    }
}
