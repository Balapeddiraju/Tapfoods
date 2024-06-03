<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.tap.model.Menu" %>  
      <%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Menu</title>

    <style>
         body {
            font-family: Arial, sans-serif;
            background-color: White;
            margin: 0;
            padding: 0;
        }
        .restaurant {
            border-bottom: 1px solid #ccc;
            padding: 20px;
            display: flex;
            align-items: center;
        }
        .restaurant img {
            width: 200px;
            height: auto;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0,0,0,0.1);
            margin-right: 20px;
        }
        .restaurant-info {
            flex: 1; /* Take remaining space */
        }
        .restaurant h2,
        .restaurant h3,
        .restaurant p,
        .restaurant b {
            margin: 0;
        }
        .restaurant h2 {
            font-size: 18px;
        }
        .restaurant h3 {
            font-size: 18px;
            color: orange;
        }
        .restaurant b {
            color: orangered;
        }
        .restaurant a {
            text-decoration: none;
            margin-right: 20px;
            color: orangered;
        }
        .restaurant a:hover {
            color: #f89faf;
        }
        .name {
            width: 5%;
            height: auto;
            border-radius: 20px;
        }
        .container{
            display: flex;
            align-items: center;
        }
        input{
          border-radius: 10px;
          border: 2px ridge orangered;
          width: 30%;
          height: auto;
         
        }
        a:hover{
            color: #f89faf;
        }
        a{
            text-decoration: none;
        }
        a{
            margin-right: 150px;
        }
        .login{
            width:5%;
            height:auto;


        }
        .text {
    position: absolute;
    bottom: 80px; /* adjust as needed */
    right: 40px;
    /* color:rgb(120, 14, 76); */
     color:rgb(175, 144, 86); 
    font-size: 50px;
    font-family: Arial, sans-serif;
    text-shadow: 2px 2px 4px #000000;
    position: relative;
    display: inline-block;
   
  }
  .cart{
            width:5%;
            height:auto;
        }
        
         .Restarunt-cont .restaurant {
    flex: 0 0 auto; /* Allow items to shrink if necessary */
} 
.Restarunt-cont .restaurant img {
    max-width: 100%; /* Ensure images don't exceed container width */
    height: auto; /* Maintain aspect ratio */
    border-radius: 50px; /* Add border radius to images */

}
        .hedder img{
            width: 1500px;
            height: 300px;
           border-radius:20px;
           
        }
        .TapFoods {
           color: orange;
  }
  h2{
            color: orangered; 
            margin-right: 300px; 
        }
        .restaurant button {
            padding: 10px 20px;
            border: none;
            background-color: orange;
            color: white;
            cursor: pointer;
            border-radius: 5px;
        }
        .restaurant button:hover {
            background-color: #f89faf;
        }
 
  
        
 
    </style>
</head>
<body>
<form action="">
 <div class="container">
        <img class="name"  src="T..........jpg" alt="Swasggiy">
        <h2>TapFoods</h2>

        <input type="text" id="search" name="q" placeholder="Search...">
        <!-- <button type="submit">Search</button> -->
        <a href="#">Search</a>

        <img class="login" src="user.png"alt="log">
        <a href="#">Login</a>
        
        <img class="cart" src="CartImg.png"alt="log">
        <a href="Login.jsp">Cart</a>
    </div>
    <hr>
   
   <div class="Restarunt-cont">
        <div class="restarunt-container">
            <% List<Menu> list = (List<Menu>) request.getAttribute("menu");
            for(Menu res :list){ %>
                <div class="restaurant">
                    <a href="MenuServlet?restaurantId=<%=res.getRestaurantId() %>">
                        <img src="<%=res.getImagepath() %>" alt="">
                    </a>
                    <div class="restaurant-info">
                        <h2><%=res.getName()%></h2>
                        <h3><%=res.getPrice()%></h3>
                        <b><%=res.getRating()%></b>
                        <p><%=res.getDescripation() %></p>
                        <a href="addtocart?menuName=<%=res.getName() %>
                        &menuPrice=<%=res.getPrice()%>
                        &menuId=<%=res.getMenuId() %>
                        &menuRes=<%=res.getRestaurantId() %>">
                        <br>
                        <button style="background-color:green;currsor:pointer">addtocart</button>
                        
                        </a>
                    </div>

                </div>
            <% } %>
        </div>
    </div>
</form>

</body>
</html>