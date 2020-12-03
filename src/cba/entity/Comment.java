package cba.entity;

public class Comment {
    private String Name;//评论人姓名
    private String Time;//评论时间
    private int Head;//评论人头像
    private String Content;//评论内容

    public Comment() {
    }

    public Comment(String name, String time, int head, String content) {
        Name = name;
        Time = time;
        Head = head;
        Content = content;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getHead() {
        return Head;
    }

    public void setHead(int head) {
        Head = head;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "OtherComment{" +
                "Name='" + Name + '\'' +
                ", Time='" + Time + '\'' +
                ", Head='" + Head + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
