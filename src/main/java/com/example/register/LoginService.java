package com.example.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired

    private LoginRepository repo;
    public Login login(String username, String password){
        Login user = repo.findByUsernameAndAndPassword(username,password);
        return user;
    }
}
