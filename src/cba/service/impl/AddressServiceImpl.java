package cba.service.impl;

import cba.dao.impl.AddressDaoImpl;
import cba.entity.Address;
import com.google.gson.Gson;

public class AddressServiceImpl {
    private AddressServiceImpl(){

    }
    private static AddressServiceImpl impl = new AddressServiceImpl();
    public static  AddressServiceImpl getInstance(){
        return  impl;
    }
    public String getAddress(int userId,int isPost){
        AddressDaoImpl impl = AddressDaoImpl.getInstance();
        return  new Gson().toJson(impl.getAddress(userId,isPost));
    }
    public void  updateAddress(Address address){
        AddressDaoImpl impl = AddressDaoImpl.getInstance();
        impl.updateAddress(address);
    }
    public void deleteAddress(int id){
        AddressDaoImpl impl = AddressDaoImpl.getInstance();
        impl.deleteAddress(id);
    }
}
