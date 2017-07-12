package com.seven.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.dao.UserDao;
import com.seven.dao.impl.UserDaoImpl;
@WebServlet("/select/doselect")
public class RegisterServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public RegisterServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("请求正常");
        
        
        UserDao user=new UserDaoImpl();

        
        String status = "用户名可以使用！";//状态：如果为0则表示该用户名不存在；否则用户名已占用

        
        //得到请求参数
        String name = request.getParameter("username");
        name = new String(name.getBytes("ISO-8859-1"),"GBK");


        System.out.println(name);
       
            if(user.isExistUsername(name)){
                status = "用户名已存在!";
            }
        
        
        //将信息返回客户端
        response.setContentType("text/html");
        response.setCharacterEncoding("GBK");
        PrintWriter out = response.getWriter();
        out.println(status);
    
        out.flush();
        out.close();
    }
}
