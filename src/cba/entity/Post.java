package cba.entity;

public class Post {
private int postId;
private int userId;
private String postTitle;
private String postText;


public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getPostTitle() {
	return postTitle;
}
public void setPostTitle(String postTitle) {
	this.postTitle = postTitle;
}
public String getPostText() {
	return postText;
}
public void setPostText(String postText) {
	this.postText = postText;
}

}
