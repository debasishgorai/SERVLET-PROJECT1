package cookieImp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie2")
public class CookieClass2  extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		Cookie[]cookies=req.getCookies();
		String name="";
		String email="";
		for(Cookie co:cookies) {
			if(co.getName().equals("name")) {
				name=co.getValue();
			}
			if(co.getName().equals("email")) {
				email=co.getValue();
			}
		}
		System.out.println(name);
		System.out.println(email);
		resp.sendRedirect("cookie3");
}}
