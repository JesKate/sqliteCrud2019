package com.example.sqlite;

public class UsuarioList {
    private int id;
    private String firsname, lastname, email, password;

    public UsuarioList(int id, String firstname, String lastname, String email, String password, String birth, int country, String phone, char gender) {
        this.id = id;
        this.firsname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public UsuarioList(String firstname, String lastname, String email, String password) {
        this.firsname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public UsuarioList(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public String getFirsname() {
        return firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
