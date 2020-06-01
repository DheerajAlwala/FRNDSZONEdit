package com.example.frndszone.Model;

public class User{
    private String phonenumber;
    private String first_name;
    private String last_name;


    public User(String phonenumber, String first_name, String last_name, String imageUri) {
        this.phonenumber = phonenumber;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    public User() {

    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
