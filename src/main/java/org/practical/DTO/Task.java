package org.practical.DTO;

import java.util.Date;

public class Task {
    private int task_id;
    private String title, tag;
    private Date due_date;

    public Task(int task_id, String title, String tag, Date due_date) {
        this.task_id = task_id;
        this.title = title;
        this.tag = tag;
        this.due_date = due_date;
    }

    public Task() {
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", due_date=" + due_date +
                '}';
    }
}
