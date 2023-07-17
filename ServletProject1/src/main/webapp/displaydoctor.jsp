
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Doctor</title>
</head>
<body>


      <%
          ResultSet rs = null;
      try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m10_e3","root","1234");
			
			String query = "SELECT * FROM doctor";
			Statement st = con.createStatement();
			 rs = st.executeQuery(query);
			 
      }catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      %>
      
      <table border="2px">
        <tr>
          <th>ID</th>
          <th>NAME</th>
          <th>AGE</th>
          <th>PHONE</th>
          <th>SPEC</th>
          <th>EDIT</th>
          <th>DELETE</th>
        </tr>
      <% 
      while(rs.next()){	  
       %>
         <tr>
         <td> <%= rs.getInt(1) %></td>
         <td> <%= rs.getString(2) %></td>
         <td> <%= rs.getInt(3) %></td>
         <td> <%= rs.getLong(4) %></td>
         <td> <%= rs.getString(5) %></td>
         <td> <a href="edit?id=<%= rs.getInt(1) %>">edit</a></td>
         <td> <a href="delete?id=<%= rs.getInt(1) %>">delete</a></td>
         </tr>
       
      <% } %>
       
      </table>
</body>
</html>