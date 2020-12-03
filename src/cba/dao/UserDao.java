package cba.dao;

public class UserDao {
    private static UserDao cdi=new UserDao();
    private UserDao () {};
    public static UserDao getInstance() {
        return cdi;
    }
    //方法
}
