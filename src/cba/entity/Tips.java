package cba.entity;


public class Tips {
    private int id;//帖子ID
    private int userId;//发帖人ID
    private String userName;//发帖人姓名
    private String userHead;//发帖人头像
    private String time;//发帖时间
    private String topic;//发帖主题
    private String title;//发帖标题
    private String text;//帖子正文
    private String thumbnail;//帖子中的图片地址
    private int likes;//点赞
    private int comments;//评论
    private int forwards;//转发

    public Tips() {
    }

    public Tips(int id, int userId, String userName, String userHead, String time, String topic, String title, String text, String thumbnail, int likes, int comments, int forwards) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userHead = userHead;
        this.time = time;
        this.topic = topic;
        this.title = title;
        this.text = text;
        this.thumbnail = thumbnail;
        this.likes = likes;
        this.comments = comments;
        this.forwards = forwards;
    }

    @Override
    public String toString() {
        return "Tips{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", time='" + time + '\'' +
                ", topic='" + topic + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", forwards=" + forwards +
                '}';
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getForwards() {
        return forwards;
    }

    public void setForwards(int forwards) {
        this.forwards = forwards;
    }


}