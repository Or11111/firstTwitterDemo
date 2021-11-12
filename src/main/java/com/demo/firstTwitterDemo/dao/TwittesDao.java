package com.demo.firstTwitterDemo.dao;

import com.demo.firstTwitterDemo.user.RandomUser;
import twitter4j.Status;

import java.util.List;

public interface TwittesDao {

    List<RandomUser> makeList(List<Status> statusList);
    
    List<RandomUser> selectAllUsers();
    
    List<RandomUser> selectUsersByCountry(String country);

    void deleteUserByName (String name);
    
}
