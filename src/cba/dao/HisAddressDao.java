package cba.dao;

import cba.entity.HisAddress;
import cba.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HisAddressDao {
    private static HisAddressDao cdi=new HisAddressDao();
    private HisAddressDao () {};
    public static HisAddressDao getInstance() {
        return cdi;
    }
    //方法
    /**
     *
     * 通过获得的userId，返回订单的历史记录
     *
     */
    public static HisAddress findaddress(int userId){
        List<HisAddress> hisAddressList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql = "select * from orders where user_id=?;";
        try {
            ps= connection.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()) {
                HisAddress hisAddress=new HisAddress();
                hisAddress.setAddressee(rs.getString(6));
                hisAddress.setAddresser(rs.getString(5));
                hisAddress.setContact(rs.getString(10));
                hisAddress.setContact1(rs.getString(17));
                hisAddress.setOrderEnd(rs.getString(3));
                hisAddress.setOrderStart(rs.getString(2));
                hisAddressList.add(hisAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (HisAddress) hisAddressList;
    }

}
