<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<style>
  body{
        background: linear-gradient(rgb(65, 63, 63),rgb(29, 234, 234));
    }
    
  
    
  
     
        h1{
            text-align:center;
            text-shadow: 2px 2px 2px orange;
        }
        input{
            border: 1px solid black;
            
        }
        
    button{
        text-decoration: none;
        border: 1px solid green; 
        background-color: cyan;
        
    }
    button:hover{
            background-color:beige;
        }

        .container {
        width: 40%;
        margin: 0 auto; 
        padding: 50px; 
        border: 1px solid ; 
        box-sizing: border-box; 
         background: linear-gradient(rgb(46, 60, 60), rgb(235, 235, 229) );
        border-radius: 20px; 
        border: 2px ridge rgb(160, 29, 29);
        }
        .Submit{
          text-align: center;
          text-decoration: none;
        }
        .Submit a{
           text-decoration: none;
           border: 1px solid bisque; 
           background-color: bisque; 
           border-radius: 5px;
           font-size:30px ;
        }
         
         a:hover{
           background-color:rgb(223, 152, 21);
         
         }
          
        .Center{
          text-align: center;
           
        }
        .Center input{
           text-decoration: none;
           border: 1px solid bisque; 
           background-color: bisque; 
           border-radius: 5px;
           font-size:30px ;
        
        }
        
        
        
            
    </style>
</head>

<body>
<form action="Signup"> 
    <h1>Signup</h1>
    <div class="container">
        Name
        <br>
        <input type="text" name="name"required placeholder="L.Balapeddiraju" >
		<br>
		<br>
		Email
        <br>
        <input type="email" name="email" required placeholder="balu@gmail.com" >
		<br>
		<br>
		Phoneno
        <br>
        <input type="text" name="phoneNo" required placeholder="9392556436">
		<br>
		<br>
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
		
		<div class="Center">
		<input  type="submit" >
		</div>
    </div>

    <br>

    <div class="Submit"> 
        
        <a href="Restaurants.jsp">Submit</a>
       
    </div>
    <br>
</form>

 <div class="login-link" style="text-align: center;">
        <span>Already Have an account?</span><a href="Login.jsp">Login</a>       
        </div>

</body>
</html>