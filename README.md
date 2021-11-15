# FirstTwitterDemo-V1

The project represents the ability to search for a specific word or phrase in @Twitter.
The result will display a list of 15 relevant Twitter users who used the above word/phrase in their last twitts. The display includes user's details like user name, screen name, location, status views.
I'm using here twitter4j library to pull data and connect to Twitter API  

In the next version (V2), I will be adding a Database and simple UI.

## Prerequisites 
1. Twitter API Permision 

    Sign in to the Twitter developer platform and ask for developer permission to use Twitter API 

    [TwitterApi](https://developer.twitter.com/en/products/twitter-api)
    
    The license includes the following four keys :
    
        *	consumer-key
        * consumer-secret
        * access-token
        * access-token-secret
    
    create under the resources package "application. properties" file and locate the four keys above. 
    
  2. Postman
  
    I'm using "Postman" as a client to test my app, but you can use any tool that you want.
    
 ## Getting data using postman

1.	To search for a word use “POST” function.
    
    localhost:8080/firstTwitterDemo/searchForWord/word_to_search

2.	Use GET to show the complete list of users who used our desired "word/phrase" in their Twitts.

3.	To choose users from specific country from our list use GET as follow :

    localhost:8080/firstTwitterDemo/selectByCountry/country

4.	To deleate user from the list according to his name use GET as follow : 

    localhost:8080/firstTwitterDemo/deleteUserByName/userToDelete

    

     

 
