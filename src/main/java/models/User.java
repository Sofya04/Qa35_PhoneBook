package models;

public class User {
    private String email;
    private String password;


    public String getEmail() {
        return email;
    }

    public User withEmail(String email) {//fluent style במקום setEmail
        this.email = email;
        return this;//return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
