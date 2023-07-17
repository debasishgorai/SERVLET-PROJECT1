package Doctor;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/savedoc")
public class SaveDoctor extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        long phone = Long.parseLong(req.getParameter("phone"));
        String spec = req.getParameter("spec");
        int row =0;
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m10_e3","root","1234");
			
			String query = "insert into doctor values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setLong(4, phone);
			ps.setString(5, spec);
		    row = ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        PrintWriter pw = resp.getWriter();
        if(row !=0) {
           pw.write("<html><body><h1> DATA SAVE SUCCESSFULLY </h1></body></html>");
           RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
           rd.include(req, resp);
        }else {
        	pw.write("<html><body><h1> SOMETHING WENT WRONG </h1></body></html>");
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.include(req, resp);
        }
	}


}
