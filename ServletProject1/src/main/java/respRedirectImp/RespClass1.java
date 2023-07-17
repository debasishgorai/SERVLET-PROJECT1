package respRedirectImp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/respclass")
public class RespClass1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		System.out.println(name+"data from servlet class");
		System.out.println(email+"data from servlet class");
		System.out.println(age+"data from servlet class");
		resp.sendRedirect("respclass2?name=&email=&age=");
}
}