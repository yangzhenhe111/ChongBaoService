package cba.service;

import cba.dao.HisAddressDao;
import cba.entity.HisAddress;

public class HisAddressService {
    private HisAddressService() {};
    private static HisAddressService csi=new HisAddressService();
    public static HisAddressService getInstance() {
        return csi;
    }
    //方法

    /**
     *
     * 通过获得userId得到历史订单
     */
    public HisAddress findaddress(int userId){
        HisAddressDao hisAddressDao = HisAddressDao.getInstance();
        HisAddress  hisAddressList = HisAddressDao.findaddress(userId);
        return hisAddressList;
    }


}
