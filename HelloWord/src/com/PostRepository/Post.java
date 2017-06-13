package com.PostRepository;

public final class Post {

	private long id;
	public String title;
	public String content ;
	public static int count;
	
	public final static String DEFAUTL_TITLE = "这是特么什么跟什么啊";
	
	public Post(){
		
		count++;
		
		id = count;
		
	}
	
	public Post(String title, String content) {
		
		this.id = count++;
		
	}
	
	
	public void print(){
		System.out.println(title+content);
		System.out.println(this.id);
	}

	public long getId() {
		 
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static final int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Post.count = count;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
	
}
