package com.example.demo.service;

import com.example.demo.dto.Vo;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository  userrepository;

    public List<User> findAll() {
        return userrepository.findAll();
    }
    public void delete(Long id) {
        userrepository.deleteById(id);
    }
    public  void insert(User user){
        userrepository.save(user);
    }
    public  void update(User user){

        Optional<User> user1 = userrepository.findById(user.getF_no());
        User user2;
        if(user1.isPresent()) user2 = user1.get();
        else return;
        user2.setF_id(user.getF_id());
        user2.setF_name(user.getF_name());
        user2.setF_pwd(user.getF_pwd());
        userrepository.save(user2);
    }
}