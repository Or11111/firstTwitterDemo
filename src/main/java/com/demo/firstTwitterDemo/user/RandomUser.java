package com.demo.firstTwitterDemo.user;


public class RandomUser {
//Specification of our basic user model
    private String name;

    private  String screenName;

    private String userLocation;

    private int statusesCount;

    public RandomUser(String name, String screenName, String userLocation, int statusesCount) {
        this.name = name;
        this.screenName = screenName;
        this.userLocation = userLocation;
        this.statusesCount = statusesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }
}
