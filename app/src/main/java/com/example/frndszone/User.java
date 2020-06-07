package com.example.frndszone;

import android.net.Uri;

public class User {

    String pNo;
    String fname;
    String lname;
    Uri imguri;

    public User() {
    }

    public User(String pNo, String fname, String lname, Uri imguri) {

        this.pNo = pNo;
        this.fname = fname;
        this.lname = lname;
        this.imguri = imguri;
    }

   //getters



    public String getpNo() {
        return pNo;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Uri getImguri() {
        return imguri;
    }
    //setters

    void setpNo(String pNo) {
        this.pNo = pNo;
    }

    void setFname(String fname) {
        this.fname = fname;
    }

    void setLname(String lname) {
        this.lname = lname;
    }

    void setImguri(Uri imguri) {
        this.imguri = imguri;
    }
}
