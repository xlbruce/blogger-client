package com.gilson.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.gilson.blogger.ApplicationProperties;
import com.gilson.client.BloggerClient;
import com.gilson.client.BloggerClientImpl;

public class BloggerServiceImpl implements BloggerService {
    
    private static final Logger LOG = Logger.getLogger(BloggerServiceImpl.class.getName());

    private BloggerClient bloggerClient;
    
    public BloggerServiceImpl() {
        String blogId = ApplicationProperties.getProperty("blog.id");
        String clientSecret = ApplicationProperties.getProperty("client.secret");
        FileInputStream clientSecretStream = null;

        try {
            clientSecretStream = new FileInputStream(clientSecret);
        } catch (FileNotFoundException e) {
            LOG.severe("Client secret file not found");
            System.exit(1);
        }

        bloggerClient = new BloggerClientImpl(blogId, clientSecretStream);
    }

    public void post(String title, String content) {
        try {
            bloggerClient.post(title, content);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "IOException occurred", e);
        }
    }
}
