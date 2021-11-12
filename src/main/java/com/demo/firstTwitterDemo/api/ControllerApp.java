package com.demo.firstTwitterDemo.api;

import com.demo.firstTwitterDemo.service.ServiceApp;
import com.demo.firstTwitterDemo.user.RandomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.TwitterException;

import java.util.List;


@RestController
//This is the path to connect our app : localhost:8080/firstTwitterDemo
@RequestMapping("/firstTwitterDemo")
public class ControllerApp {

    private final ServiceApp serviceApp;

    @Autowired
    public ControllerApp(ServiceApp serviceApp) {
        this.serviceApp = serviceApp;
    }

    //Implement a post request, looking for a specific word or phrase, and make a list of those users
    @PostMapping("searchForWord/{quoteForSearch}")    //localhost:8080/firstTwitterDemo/searchForWord/covid19
    public void searchForWord(@PathVariable("quoteForSearch") String quoteForSearch) throws TwitterException {
        serviceApp.searchQuery(quoteForSearch);
    }

    //Get a complete list of users that used our desired "word/phrase" in their Twitts
    @GetMapping
    public List<RandomUser> getAllList(){
        return serviceApp.getAllUsers();
    }

    //Get users by specific country from our list
    @GetMapping("selectByCountry/{country}")        //localhost:8080/firstTwitterDemo/selectByCountry/country
    public List<RandomUser> getUsersByCountry(@PathVariable("country") String country ) {
        return serviceApp.getUsersByCountry(country);
    }

    //Delete specific users from our list by their name
    @GetMapping("deleteUserByName/{userToDelete}")       //localhost:8080/firstTwitterDemo/deleteUserByName/userToDelete
    public void deleteUserByName(@PathVariable("userToDelete") String userToDelete ){
      serviceApp.deleteUserByName(userToDelete);
    }

}
