package vn.hrtech.myapplication.Modals;

import com.google.gson.Gson;

public class User {
    private String Id = "Test";
    private String Username = "@test";
    private String Password = "12345678";
    private String Role = "";
    private String Token = "";

    public static User data = new User();

    public void setToken(String token) {
        Token = token;
    }

    public String getToken() {
        return Token;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void getObject(String jsonString) {
        Gson gson = new Gson();
        User user = gson.fromJson(jsonString, User.class);
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setRole(user.getRole());
    }
}
