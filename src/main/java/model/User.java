package model;

/**
 * @description this class it used for instance or declare a user
 * @author Jacobo Vargas García
 * @version 1.0
 * @since 2023
 *
 */

public class User {
    private String user;
    private String password;
    private final String  document;
    private String name;
    private String lastName;
    private int age;
    private String mail;
    private Gender gender;

    /**
     * @description this a constructor for declare a user with their attributes
     * @param age age of user type int
     * @param document id or identification type string
     * @param gender gender it's enum of class model.Gender
     * @param name name of user type string
     * @param lastName lastname of user type string
     * @param user nickname of user type string
     * @param password password of user type string
     * @param mail mail of user type string
     */
    public User(int age, String document, Gender gender, String name, String lastName, String user, String password, String mail){
        this.age        = age;
        this.document   = document;
        this.gender     = gender;
        this.name       = name;
        this.lastName   = lastName;
        this.user       = user;
        this.password   = password;
        this.mail       = mail;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}