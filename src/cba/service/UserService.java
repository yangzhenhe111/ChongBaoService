package cba.service;

import cba.dao.UserDao;
import cba.entity.User;

public class UserService {
    private UserService() {};
    private static UserService csi=new UserService();
    public static UserService getInstance() {
        return csi;
    }
    //方法

    /**
     *
     * @param phone 通过输入的手机号判断用户是否存在
     * @return true 存在
     * false 不存在
     */
    public boolean isExist(String phone){
        UserDao userDao = UserDao.getInstance();
        boolean b = userDao.isExist(phone);
        return b;
    }

    /**
     * 注册新用户
     * @param phone 注册用的手机号
     * @param pass 注册的密码
     * @return true 注册成功
     * false 注册失败
     */
    public boolean Register(String phone,String pass){
        UserDao userDao = UserDao.getInstance();
        boolean b = userDao.Register(phone,pass);
        return b;
    }

    /**
     * 修改用户信息
     * @param user
     * @return true 修改成功
     */
    public boolean Updata(User user){
        UserDao userDao = UserDao.getInstance();
        boolean b = userDao.upData(user);
        return b;
    }

    public boolean UpdataPassword(String phone,String password){
        UserDao userDao = UserDao.getInstance();
        boolean b = userDao.UpdataPassword(phone,password);
        return b;
    }
}
