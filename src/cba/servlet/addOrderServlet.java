package cba.servlet;

import cba.entity.Order;
import cba.entity.Pet;
import cba.service.impl.OrderServiceImpl;
import cba.service.impl.PetServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/addOrderServlet")
public class addOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        InputStream in = request.getInputStream();
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        String jsonStr = new String(buffer, 0, len,"UTF-8");
        System.out.println(jsonStr);
        Gson gson = new Gson();
        Order order = gson.fromJson(jsonStr,Order.class);
        System.out.println(order.toString());

        OrderServiceImpl orderService = OrderServiceImpl.getInstance();
        boolean b = orderService.insetOrder(order);
        System.out.println(b);
        if(b){
            System.out.println("³É¹¦");
            response.getWriter().append("true");
        }else {
            System.out.println("Ê§°Ü");
            response.getWriter().append("false");
        }
    }
}
