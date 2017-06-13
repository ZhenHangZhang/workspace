package com.PostRepository;
import com.PostRepository.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 


public class MapPostRepositiry {

    private static Map<Long, Post> postsMap = new HashMap<Long, Post>();
    
    public static void add(Post post) {
        postsMap.put(post.getId(), post);
    }
    
    public static Post getPostById(long id) {    
        return postsMap.get(id);
    }
    
    public static void remove(long id) {
        postsMap.remove(id);
    }
    
    public static List<Post> getAll() {
        List<Post> posts = new ArrayList<>();      
        posts.addAll(postsMap.values());
        return posts;
    } 
    
}
