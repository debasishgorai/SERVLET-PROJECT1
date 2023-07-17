package com.debasish.admindata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.debasish.admindata.dao.AdminDAO;
import com.debasish.admindata.dto.Admindto;
@WebServlet("/saveadmin")
public class SaveAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dept=req.getParameter("dept");
		String password=req.getParameter("password");
		Admindto admindto=new Admindto();
		admindto.setName(name);
		admindto.setEmail(email);
		admindto.setDept(dept);
		admindto.setPassword(password);
		resp.getWriter().write(new AdminDAO().saveAdmin(admindto));
		
	}
}
