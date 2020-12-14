package cba.servlet;

import cba.entity.Address;
import cba.service.impl.AddressServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/UpdateAddress")
public class UpdateAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        InputStream in = request.getInputStream();
        byte [] bytes= new byte[256];
        StringBuilder builder = new StringBuilder();
        int len = 0;
        while ((len = in.read(bytes))!=-1){
            builder.append(new String(bytes,0,len,"utf-8"));
        }
        Address address  = new Gson().fromJson(builder.toString(),Address.class);
        AddressServiceImpl impl = AddressServiceImpl.getInstance();
      impl.updateAddress(address);

    }
}
