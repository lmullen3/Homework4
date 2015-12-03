package edu.elon.business;

//Copyright (c) 2015 Maddie Chili and Lawrence Mullen

import java.io.Serializable;

/**
 *
 * @author lawrencemullen && maddiechili
 */
public class User implements Serializable {

    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private String dueDate;
    private String overdue;

    /**
     *default constructor for user object
     */
    public User() {
        email = "";
        firstName = "";
        lastName = "";
        title = "";
        dueDate = "";
        overdue = "";
    }

    /**
     * constructor for the user object taking parameters
     * @param firstName
     * @param lastName
     * @param email
     * @param title
     * @param dueDate
     * @param overdue
     */
    public User(String firstName, String lastName, String email, String title, String dueDate, String overdue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        this.dueDate = dueDate;
        this.overdue = overdue;
    }

    /**
     *getter method for email string
     * @return string email
     */
    public String getEmail() {
        return email;
    }

    /**
     *setter method for email string
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *getter method for firstname string
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *setter method for firstname string
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter method for lastname string
     * @return last name string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *setter method for last name string 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *getter method for title string
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * setter method for title string
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *getter method for book due date
     * @return due date
     */
    public String getDueDate(){
        return dueDate;
    }

    /**
     * setter method for book due date
     * @param cal
     */
    public void setDueDate(String cal){
        this.dueDate = cal;
    }

    /**
     *getter method for overdue string
     * @return overdue string
     */
    public String getOverdue(){
        return overdue;
    }

    /**
     *setter method for overdue string
     * @param overdue
     */
    public void setOverdue(String overdue){
        this.overdue = overdue;
    }
}