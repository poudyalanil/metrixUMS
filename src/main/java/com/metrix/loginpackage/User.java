/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metrix.loginpackage;

/**
 *
 * @author College
 */
public class User {
    private int iduser;
    private String firstName, middleName, lastName, address, email, password;
    
    public User() {

    }

    
    public User(int iduser, String firstName, String middleName, String lastName, String address, String email, String password ){
        this.iduser = iduser;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public User(String firstName, String middleName, String lastName, String address, String email, String password ){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        
    }

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
    
    @Override
    public String toString() {
        return "user{" + "iduser=" + iduser + ", FirstName=" + firstName + ", MiddleName=" + middleName + ", LastName=" + lastName + ", address=" + address + ", email =" + email + ", Password=" + password +'}';
    }
}

