package com.seven.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.seven.dao.UserDao;
import com.seven.dao.impl.UserDaoImpl;
import com.seven.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private String resultMsg;

	// 重写doGet方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户填写的登录用户名
		String username = request.getParameter("username");
		// 获取用户填写的登录密码
		String password = request.getParameter("password");
		UserDao userDao = new UserDaoImpl();
		// 用户登录
		User user = userDao.isExist(username, password);

		if (user == null) {
			String message = String.format(
					"对不起，用户名或密码有误！！请重新登录！秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content=';url=%s'",
					request.getContextPath() + "/servlet/LoginUIServlet");
			request.setAttribute("message", message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		// 登录成功后，就将用户存储到session中
		request.getSession().setAttribute("user", user);
		String message = String.format("恭喜：%s,登陆成功！本页将在3秒后跳到首页！！<meta http-equiv='refresh' content='3;url=%s'",
				user.getUsername(), request.getContextPath() + "/index.jsp");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
