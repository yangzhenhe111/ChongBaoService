package cba.servlet;

import cba.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/DeleteAddress")
public class DeleteAddress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
       int id  = Integer.parseInt(request.getParameter("id"));

        AddressServiceImpl impl = AddressServiceImpl.getInstance();
       int count = impl.deleteAddress(id);
       if(count !=0){
 response.getOutputStream().write("移出成功".getBytes("utf-8"));
       }

    }
}
