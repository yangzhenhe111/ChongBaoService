package cba.servlet;

import cba.entity.User;
import cba.service.UserService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdataUserInfoServlet")
public class UpdataUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("连接成功！");
        //获得磁盘文件条目工厂。
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //获取文件上传需要保存的路径，upload文件夹需存在。
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
//        String path = "F:\\test";

        //设置暂时存放文件的存储室，这个存储室可以和最终存储文件的文件夹不同。因为当文件很大的话会占用过多内存所以设置存储室。
        factory.setRepository(file);
        //设置缓存的大小，当上传文件的容量超过缓存时，就放到暂时存储室。
        factory.setSizeThreshold(1024*1024);
        //上传处理工具类（高水平API上传处理？）
        ServletFileUpload upload = new ServletFileUpload(factory);


        User user = new User();
        try{
            //调用 parseRequest（request）方法  获得上传文件 FileItem 的集合list 可实现多文件上传。
//            Map<String, List<FileItem>> lists = (Map<String, List<FileItem>>) upload.parseRequest(request);
//            file=[name=head.jpg, StoreLocation=null, size=3366 bytes, isFormField=false, FieldName=file]实例数据
//            Util.log(TAG,lists);

            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item:list){
                //获取表单属性名字。
                String name = item.getFieldName();
                //如果获取的表单信息是普通的文本信息。即通过页面表单形式传递来的字符串。
                if(item.isFormField()){
                    //获取用户具体输入的字符串，
                    String value = item.getString();
                    //                    System.out.println(value);
                    System.out.println(name+":"+value);
                    switch (name){
                        case "name":
                            user.setUserName(value);
                            break;
                        case "brithday":
                            user.setUserBrithday(value);
                            break;
                        case "sex":
                            user.setUserSex(value);
                            break;
                        case "synopsis":
                            user.setUserAutograph(value);
                            break;
                        case "phone":
                            user.setUserPhone(value);
                            break;
                    }
                }
                //如果传入的是非简单字符串，而是图片，音频，视频等二进制文件。
                else{
                    //获取路径名
                    String value = item.getName();
                    //取到最后一个反斜杠。
                    int start = value.lastIndexOf("\\");
                    //截取上传文件的 字符串名字。+1是去掉反斜杠。
                    String filename = value.substring(start+1);
                    //                    request.setAttribute(name, filename);
                    System.out.println(name+":"+filename);
                    user.setPicturePath(filename);

                    /*直接写到文件中。 */
                    item.write(new File(path,filename));
                }
            }
            response.getWriter().append("true");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
