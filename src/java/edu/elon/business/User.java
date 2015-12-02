package edu.elon.business;

import java.io.Serializable;
public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private String dueDate;
    private String overdue;

    public User() {
        email = "";
        firstName = "";
        lastName = "";
        title = "";
        dueDate = "";
        overdue = "";
    }

    public User(String firstName, String lastName, String email, String title, String dueDate, String overdue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.dueDate = dueDate;
        this.overdue = overdue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDueDate(){
        return dueDate;
    }
    public void setDueDate(String cal){
        this.dueDate = cal;
    }
     public String getOverdue(){
        return overdue;
    }
    public void setOverdue(String overdue){
        this.overdue = overdue;
    }
}