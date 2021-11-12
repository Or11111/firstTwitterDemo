package com.demo.firstTwitterDemo.service;

import com.demo.firstTwitterDemo.cofig.ConfigurationApp;
import com.demo.firstTwitterDemo.dao.TwittesDao;
import com.demo.firstTwitterDemo.user.RandomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

@Service
public class ServiceApp {

    private final ConfigurationApp configurationApp;
    private final TwittesDao twittesDao;


  // Service app depend parallel on "configurationApp" to make Twitter API connection and the "TwittesDaoDataAccessService"
    @Autowired
    public ServiceApp(ConfigurationApp configurationApp, @Qualifier("TwittesDaoDataAccessService") TwittesDao twittesDao) {
        this.configurationApp = configurationApp;
        this.twittesDao = twittesDao;
    }


    //Search for a Query :
    //1. Establish connection to Twitter API
    //2. Searching our query(word/phrase)
    //3. Make a "status list" of relevant users
    //4. Calling "make a list" to pull the relevant details we want from the users.
    public void searchQuery(String stringToSearch) throws TwitterException {
       System.out.println("stringToSearch =   "+stringToSearch);
        configurationApp.twitterFactory();
        Query query = new Query(stringToSearch);
        QueryResult result = configurationApp.getTwitter().search(query);
        List<Status> statusList = result.getTweets();
        twittesDao.makeList(statusList);
    }

    public List<RandomUser> getAllUsers(){
        return twittesDao.selectAllUsers();
    }

    public List<RandomUser> getUsersByCountry (String selectedCountry){
        return twittesDao.selectUsersByCountry(selectedCountry);
    }

    public void deleteUserByName (String userToDelete){
        twittesDao.deleteUserByName(userToDelete);
    }


}
