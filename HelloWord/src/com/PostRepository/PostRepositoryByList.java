package com.PostRepository;

import java.util.List;

import com.customLog.BlogAppException;

public interface PostRepositoryByList {

	
	   public void add(Post post);
	    
	    public Post getPostById(long id);
	    
	    public void remove(long id);
	    
	    public List<Post> getAll();  
	    
	    public void loadData() throws BlogAppException;
	    
	    public void saveData();  
	
	
	
}
