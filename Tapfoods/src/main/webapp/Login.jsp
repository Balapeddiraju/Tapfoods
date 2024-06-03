<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<style>
  body{
        background: linear-gradient(to right, rgb(31, 10, 10), rgb(186, 126, 13),rgb(61, 56, 56));
    }
        h1{
            text-align: center;
            
        }
        input{
            border: 1px solid black;
        }
        a:hover{
            background-color:color(srgb red green blue);
        }
        .center a{
            text-decoration: none;
            text-align:center;
            color:green;
             border: 1px solid green;
             border-radius:5px; 
            font-size:30px ;
          
        }
        
       
        .container {
        width: 40%;
        margin: 0 auto; 
        padding: 70px; 
        border: 2px ridge orangered;
        box-sizing: border-box; 
        background-color:rgb(29, 234, 234);
        border-radius: 30px;
    }
    
    h1{
            text-shadow: 2px 2px 2px burlywood;
            
        }
        
         .center{
            text-align: center;
           
        }
        a:hover{
            background-color:rgb(180, 122, 101);
            border-radius: 5px;
        }
        
        body{
        
        background-color:rgb(236, 236, 145);
        }
        .top a{
          
          text-decoration: none;
          color: orange;
        }
        .top a:hover{
          color: lime;
        }
        .center input{
           text-decoration: none;
           border: 1px solid bisque; 
           background-color: green; 
           border-radius: 5px;
           font-size:30px ;
        }
         input:hover{
           background-color:rgb(223, 152, 21);
           }
           
           .top-center{
             
             color: red;
           }
            
    </style>
</head>
<body>
    <form action="Login">
    <h1>Login</h1>
    <div class="container">
    Username
        <br>
        <input type="text" name="username"required placeholder="balapeddiraju">
		<br>
		<br>
        Password
        <br>
        <input type="password" name="password" required placeholder="Balu@123">
		<br>
        <br>
    </div>
    <br>
    <div class="center">
    
    <input type="submit">
    
    </div>
    </form>
    <br>
    <div class="Signup-link" style="text-align: center;">
        <span>Don't Have an account?</span><a href="Signup.jsp">Signup</a>       
     </div>
     
     <div class="top-center">
     
    <%
    if(request.getAttribute("count") != null) {
        int count = (int) request.getAttribute("count");
        if(count > 0) {
%>
    <h1 class="top-center">Enter Valid Password <%= count %> Attempts left</h1>
<%
        } 
        else {
%>
    <h1 class="top"><a href="Signup.jsp"><----Attempts Over Please Contact Admin----></a></h1>
<%
        }
    }
%>


     </div>
        
</body>
</html>