package cba.service;

public class UserService {
    private UserService() {};
    private static UserService csi=new UserService();
    public static UserService getInstance() {
        return csi;
    }
    //方法
}
