package respRedirectImp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/respclass2")
public class RespClass2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		System.out.println("doGet() of second class is execute");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String age=req.getParameter("age");
		System.out.println(name+"data from  second servlet class");
		System.out.println(email+"data from second  servlet class");
		System.out.println(age+"data from second servlet class");
}
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		System.out.println("doPost() of second class is execute");
	}	
}