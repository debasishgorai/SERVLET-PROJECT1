package Doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewDoctors extends HttpServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 3095410032663504405L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m10_e3","root","1234");
			
			String query = "SELECT * FROM doctor";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			PrintWriter pw = resp.getWriter();
			
			pw.write("<html><body>");
			pw.write("<table border= 2px><tr>");
			pw.write("<th>ID</th>");
			pw.write("<th>NAME</th>");
			pw.write("<th>AGE</th>");
			pw.write("<th>PHONE</th>");
			pw.write("<th>SPEC</th>");
			pw.write("</tr>");
			
			while(rs.next()) {
				pw.write("<tr>");
				pw.write("<td>"+rs.getInt(1)+"</td>");
				pw.write("<td>"+rs.getString(2)+"</td>");
				pw.write("<td>"+rs.getInt(3)+"</td>");
				pw.write("<td>"+rs.getLong(4)+"</td>");
				pw.write("<td>"+rs.getString(5)+"</td>");
				pw.write("</tr>");
			}
			pw.write("</table>");
			pw.write("</body></html>");
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
}

}
