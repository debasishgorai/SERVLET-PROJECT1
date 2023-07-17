package com.debasish.admindata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/mastermenu")
public class MasterMenu  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		Object value=req.getAttribute("aa");
		System.out.println(value);
		
		out.write("<h1>"+"Welcome to master menu"+"<h1>");
		out.write("<a href=saveAdmin.html>To save a new Admin</a>");
	}
}
