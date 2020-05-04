package com.example.fragmentsrecyclerview;

public class Item {
    private String day;
    private String task;
    private String details;

    public Item(String day, String task, String details) {
        this.day = day;
        this.task = task;
        this.details = details;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
