package com.gilson.blogger;

import com.gilson.service.BloggerService;
import com.gilson.service.BloggerServiceImpl;

public class Application {
    
    public static void main(String... args) {
        if (args.length != 2) {
           System.err.println("Usage: java -jar blogger-client.jar <title> <post content>"); 
           System.exit(1);
        }

        String title = args[0];
        String content = args[1];
        
        BloggerService service = new BloggerServiceImpl();
        service.post(title, content);
    }
}
