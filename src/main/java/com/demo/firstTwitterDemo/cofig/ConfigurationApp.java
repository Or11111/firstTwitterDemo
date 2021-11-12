package com.demo.firstTwitterDemo.cofig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class ConfigurationApp {
    //pulled four values below from the "resources/application.properties" file
    @Value("${consumer-key}")
    private String consumerKey;

    @Value("${consumer-secret}")
    private String consumerSecret;

    @Value("${access-token}")
    private String accessToken;

    @Value("${access-token-secret}")
    private String accessTokenSecret;

    private twitter4j.Twitter twitter;

    public Twitter getTwitter() {
        return twitter;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }


    public void twitterFactory()  {

        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
              .setOAuthConsumerKey(getConsumerKey())
              .setOAuthConsumerSecret(getConsumerSecret())
              .setOAuthAccessToken(getAccessToken())
              .setOAuthAccessTokenSecret(getAccessTokenSecret());

        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
      //  tf.getSingleton();    // to check if i need this or its related to android applications

        }

}
