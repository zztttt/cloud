package app.dao;


import app.entity.UserAuth;

public interface UserDao {

    UserAuth checkUser(String username, String password);
}
