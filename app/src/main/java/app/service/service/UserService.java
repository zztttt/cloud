package app.service.service;


import app.entity.UserAuth;

public interface UserService {

    UserAuth checkUser(String username, String password);
}
