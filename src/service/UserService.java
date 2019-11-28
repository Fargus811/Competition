package service;

import entity.Coach;
import repository.InMemoryCoachRepository;
import repository.InMemorySportsmanRepository;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance;

    private UserService(){

    }
    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public boolean login(String login, String password) {
        return  "admin".equals(login) && "admin".equals(password);
    }

    public List<Object>  showAll(){
       List<Object> users = new ArrayList<>();
       users.addAll(InMemoryCoachRepository.getInstance().findAll());
       users.addAll(InMemorySportsmanRepository.getInstance().findAll());
       return users;
    }
}

