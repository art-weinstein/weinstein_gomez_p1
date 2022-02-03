package com.revature.models;

//Model is designed to represent Data that we want to maintain within our application.
public class Profile {

    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;

    //No-Arg Constructor
    public Profile() {
    }

    //Full-Arg Constructor
    public Profile(int id, String firstName, String lastName, String middleName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }

    //ID-less Constructor
    public Profile(String firstName, String lastName, String middleName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lasName=" + lastName +
                ", middleName=" + middleName +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}