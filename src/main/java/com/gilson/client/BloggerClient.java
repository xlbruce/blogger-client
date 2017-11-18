package com.gilson.client;

import java.io.IOException;

public interface BloggerClient {
    
    public void post(String title, String content) throws IOException;

}
