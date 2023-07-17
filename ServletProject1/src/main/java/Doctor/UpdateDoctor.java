package Doctor;

import java.io.IOException;
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

@WebServlet("/update")
public class UpdateDoctor extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        long phone = Long.parseLong(req.getParameter("phone"));
        String spec = req.getParameter("spec");
        
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m10_e3","root","1234");
		

			String query = "UPDATE doctor SET name=?,age=?,phone=?,spec=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setLong(3, phone);
			ps.setString(4, spec);
			ps.setInt(5, id);
		    ps.executeUpdate();

		ps.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
       RequestDispatcher rd = req.getRequestDispatcher("displaydoctor.jsp");
        rd.forward(req, resp);
		}
        
       
        
	}

}


