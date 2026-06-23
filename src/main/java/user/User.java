/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

/**
 *
 * @author zendy
 */
public abstract class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
        
    public boolean login(String emailInput,String passwordInput){
        return this.email.equals(emailInput) && this.password.equals(passwordInput);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
    
    public String getPassword() {
    return password;
}

    public abstract void tampilkanMenu();
}