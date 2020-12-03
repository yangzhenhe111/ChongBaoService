package cba.entity;

public class Topic {
    private String name;//主题
    private String count;//主题帖子数量

    public Topic() {
    }

    public Topic(String name, String count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "name='" + name + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
