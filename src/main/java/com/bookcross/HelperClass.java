package com.bookcross;

public class HelperClass {

    String name;
    String email;
    String userName;
    String password;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    String idUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HelperClass(String name, String email, String userName, String password, String idUser) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public HelperClass() {
    }
}
