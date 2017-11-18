package com.gilson.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.gilson.blogger.ApplicationProperties;
import com.gilson.client.BloggerClient;
import com.gilson.client.BloggerClientImpl;

public class BloggerServiceImpl implements BloggerService {
    
    private BloggerClient bloggerClient;
    
    public BloggerServiceImpl() {
        String blogId = ApplicationProperties.getProperty("blog.id");
        String clientSecret = ApplicationProperties.getProperty("client.secret");
        FileInputStream clientSecretStream = null;

        try {
            clientSecretStream = new FileInputStream(clientSecret);
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] Client secret file not found");
        }

        bloggerClient = new BloggerClientImpl(blogId, clientSecretStream);
    }

    public void post(String title, String content) {
        try {
            bloggerClient.post(title, content);
        } catch (IOException e) {
            System.err.println("[ERROR] Could not post into Blogger");
            e.printStackTrace();
        }
    }
}
