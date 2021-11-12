package com.demo.firstTwitterDemo.dao;

import com.demo.firstTwitterDemo.user.RandomUser;
import org.springframework.stereotype.Repository;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;

@Repository("TwittesDaoDataAccessService")
public class TwittesDaoDataAccessService implements TwittesDao{

    private static List<RandomUser> DB = new ArrayList<>();


    //Make a list of users with the following details: name, screen name, location, status views
    @Override
    public List<RandomUser> makeList(@org.jetbrains.annotations.NotNull List<Status> statusList) {
        for (Status status : statusList) {
           DB.add(new RandomUser(status.getUser().getName(),
                   status.getUser().getScreenName(),
                   status.getUser().getLocation(),
                   status.getUser().getStatusesCount()));
        }
        return null;
    }

    @Override
    public List<RandomUser> selectAllUsers() {
        return DB;
    }

    @Override
    public List<RandomUser> selectUsersByCountry(String country) {
        List<RandomUser> dbListByCountry = new ArrayList<>();
        for (RandomUser random: DB) {
            if(random.getUserLocation().equals(country)){
                dbListByCountry.add(random);
            }
        }
        return dbListByCountry;
    }

    @Override
    public  void deleteUserByName(String userToDelete) {
       for(RandomUser random : DB){
           RandomUser user=null;
           if(random.getName().equals(userToDelete)){
              user = random;
           }
           DB.remove(user);
       }
    }


}
