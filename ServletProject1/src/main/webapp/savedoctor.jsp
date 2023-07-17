<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DoctorDetails</title>
<style type="text/css">
   #a{ color: white;
       background-color: black;
     }
     pre{
      margin-top:7px;
      border: 2px solid red;
      background-color: grey;
      background-size: cover;
     }
   
</style>
</head>
<body>
<form action="savedoc" method="post">
    <pre>
       ID             : <input type="number" name="id" placeholder="enter your id">
       
       NAME           : <input type="text" name="name" placeholder="enter your name">
       
       AGE            : <input type="number" name="age" placeholder="enter your age">
       
       PHONE          : <input type="tel" name="phone" placeholder="enter your mobile number">
       
       SPECIALIZATION : <input type="text" name="spec" placeholder="enter your specialization">
       
                           <input type="submit" value="SAVE" id="a">
    </pre>
  </form>
</body>
</html>