package sessionImp;

import java.io.IOException;
import sessionImp.DataHandler;
//import javax.activation.DataHandler;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/session1")
public class SessionClass1 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		DataHandler data= new DataHandler(name,email,age);
		HttpSession session= req.getSession();
		session.setAttribute("data", data);
		resp.sendRedirect("session2");
}
}
