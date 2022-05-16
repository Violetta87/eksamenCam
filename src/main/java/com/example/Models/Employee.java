package com.example.Models;

public class Employee {

    private String username;
    private String password;
    private String email;
    private int phoneNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private int employeeID;
    private int employmentRoleID;

    public Employee(String username, String password, String email, int phoneNumber, String firstName, String middleName, String lastName, int employeeID, int employmentRoleID) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.employmentRoleID = employmentRoleID;
    }

    public Employee(String username, String password, int employeeID, int employmentRoleID){
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
        this.employmentRoleID = employmentRoleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getEmploymentRoleID() {
        return employmentRoleID;
    }

    public void setEmploymentRoleID(int employmentRoleID) {
        this.employmentRoleID = employmentRoleID;
    }
}
