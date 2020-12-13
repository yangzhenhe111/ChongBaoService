package cba.dao.impl;

import cba.entity.Address;
import cba.utils.DBUtil;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl {
    private AddressDaoImpl(){

    }
    private static AddressDaoImpl impl = new AddressDaoImpl();
    public static AddressDaoImpl getInstance(){
        return impl;
    }
    public List<Address> getAddress(int userId,int isPost){
        Connection cn = DBUtil.getConnection();
        String sql ="select * from address where userid =? and isPost=?";
        PreparedStatement ps = null;
        ResultSet rs=null;
        List list =  new ArrayList();
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,isPost);
            rs= ps.executeQuery();
            while (rs.next()){
                Address address = new Address();
                address.setAddress(rs.getString("address"));
                address.setId(rs.getInt("id"));
                address.setPeople(rs.getString("people"));
                address.setTel(rs.getString("tel"));
                list.add(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(rs,rs,ps,cn);
        }
        return  list;
    }
    public void  updateAddress(Address address){
        Connection cn = DBUtil.getConnection();
        String sql ="update address set address =? , people=? , tel=? where id =?";
        PreparedStatement ps = null;

        try {
            ps =cn.prepareStatement(sql);
            ps.setString(1,address.getAddress());
            ps.setString(2,address.getPeople());
            ps.setString(3,address.getTel());
            ps.setInt(4,address.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {

        }

    }
    public void deleteAddress(int id){
        Connection cn = DBUtil.getConnection();
        String sql ="delete from address where id =?";
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            ps= cn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(rs,rs,ps,cn);
        }
    }
}
