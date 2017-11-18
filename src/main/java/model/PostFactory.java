package model;

import com.google.api.services.blogger.model.Post;

public class PostFactory {
    
    public static Post createPost(String title, String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        return post;
    }
}
