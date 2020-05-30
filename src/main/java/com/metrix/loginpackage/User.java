package com.metrix.loginpackage;

import java.time.LocalDate;

// User model for user's opertation
public class User {

    private int iduser, userRole, userStatus;
    private String firstName, middleName, lastName, address, email, password;
    private LocalDate joinDate;

    public User() {

    }

    public User(int iduser, String firstName, String middleName, String lastName, String address, String email, String password, LocalDate joinDate, int userRole, int userStatus) {
        this.iduser = iduser;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.userRole = userRole;
        this.userStatus = userStatus;

    }

    public User(String firstName, String middleName, String lastName, String address, String email, String password, LocalDate joinDate, int userRole, int userStatus) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }
// getters
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    //setters
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    //parsing data to string
    @Override
    public String toString() {
        return "user{" + "iduser=" + iduser
                + ", FirstName=" + firstName
                + ", MiddleName=" + middleName
                + ", LastName=" + lastName
                + ", address=" + address
                + ", email =" + email
                + ", Password=" + password
                + ", Joined Date = " + joinDate
                + ", User Role = " + userRole
                + ", User Status = " + userStatus
                + '}';
    }
}
