package com.debasish.admindata.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debasish.admindata.dao.AdminDAO;
import com.debasish.admindata.dto.Admindto;
@WebServlet("/loginadmin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		AdminDAO dao=new AdminDAO();
		String email=req.getParameter("name");
		String password= req.getParameter("password");
		req.setAttribute("aa", new Admindto());
		Admindto admin=dao.adminLogin(email, password);
		if(admin.getId()!=0) {
		if(admin.getDept().equals("master")) {
			RequestDispatcher rd=req.getRequestDispatcher("mastermenu");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("adminmenu");
			rd.forward(req, resp);
		}
		
		
	
	}
	else {
		RequestDispatcher rd=req.getRequestDispatcher("invalidadmin");
		rd.forward(req, resp);
	}
}
}