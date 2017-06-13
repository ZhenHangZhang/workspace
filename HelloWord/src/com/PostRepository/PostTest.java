package com.PostRepository;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.customLog.BlogAppException;

public class PostTest implements PostRepositoryByList {

	
	private static final PostTest postTest = new PostTest();

	
	public static PostTest instance() {
	// TODO Auto-generated constructor stub
		return postTest;
		
	}
	private  PostTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public void add(Post post) {
		// TODO Auto-generated method stub

	}

	@Override
	public Post getPostById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadData() throws BlogAppException {
		// TODO Auto-generated method stub

		File dir = new File("floder");
				
	    List<File>files = (List<File>) FileUtils.listFiles(dir, null, true);
		
		
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub

	}

}
