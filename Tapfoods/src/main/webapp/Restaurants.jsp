<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="com.tap.model.Restaurant" %>  
      <%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Restaurant</title>
<style>
        .restarunt-container{
            display:flex;
            flex-wrap:wrap;
            justify-content:center;
            gap:20px;
            padding:20px;
        } 
        .restaurant{
            text-align: center;
            width: calc(33.33% - 20px);
            
            
        }
        .restaurant img{
            width: 70%;
            height: auto;
            border-radius: 10px;
            box-shadow: 0px 4px 6px rgba(0,0,0,0.1) ;
        }
        .restaurant h2{
            margin-top:10px;
            fornt-size:18px;
            color:#333;
        }
        .hedder{
            text-align: center;
            margin-bottom: 2px;
            /* background-color:black; */
            padding: 30px;
            color: white;
            padding-right: 300px;
           
        }
        
        body{
            background-color:White;
        }
         h2{
            color: orangered; 
           
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
          margin-left: 200px;
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
            width:7%;
            height:auto;
            


        }
        .signup{
            width:7%;
            height:auto;
        }
        .cart{
            width:7%;
            height:auto;
        }
        .Restarunt-cont {
    display: flex;
    flex-wrap: nowrap; /* Ensure items don't wrap */
    overflow-x: auto; /* Enable horizontal scrolling if necessary */
    
    
    /* padding: 10px; Add padding as needed */
   
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
           position: fixed;
           top: 50%;
           left: 50%;
           transform: translate(-50%, -50%);
           font-size: 48px;
            color: rgba(0, 0, 0, 0.1); /* Adjust opacity as needed */
            pointer-events: none; /* Ensures the watermark doesn't interfere with mouse events */
           z-index: 9999; /* Ensures the watermark appears on top of other content */
           font-family: Arial, sans-serif; /* Choose your preferred font-family */
           font-weight: bold;
           white-space: nowrap; /* Prevents the text from wrapping */
           writing-mode: sideways-lr; /* Rotates the text vertically */ 
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
  
  .rating-icon{
    color: red;
    font-size: 20px;
    vertical-align: middle;
    line-height: 1;
  }
  .Eta{
    margin-right: 10px;
    color: black;
    
  
  }
  .CuisineType{
    font-size: 16px;
    margin-bottom: 5px;
    color: black;
  }
  .Address{
    color: black;
  
  }
  .username{
    text-align: center;
    
     color:rgb(142, 214, 34);
  
  }
  .span{
     color: orange;
  
  }
  /* Add motion effect on click */
.restarunt-container .restaurant a {
    display: inline-block;
    position: relative;
    transition: transform 0.3s ease;
}

.restarunt-container .restaurant a:hover {
    transform: scale(1.1);
}


/* Add motion effect on click */
.Restarunt-cont .restaurant img {
    transition: transform 0.3s ease; /* Smooth transition effect */
}

.Restarunt-cont .restaurant img:hover {
    transform: scale(1.1); /* Scale up the image on hover */
}

.Restarunt-cont .restaurant img:active {
    transform: scale(0.9); /* Scale down the image when clicked */
}


/* Add motion effect on click */
.motion-effect img {
    transition: transform 0.3s ease; /* Smooth transition effect */
}

.motion-effect img:hover {
    transform: scale(1.1); /* Scale up the image on hover */
}

.motion-effect img:active {
    transform: scale(0.9); /* Scale down the image when clicked */
}
span {
  color: gold; /* Change the color of the star */
}
.container
{
   background: linear-gradient(to right, #ff7e5f, #feb47b,rgb(80, 76, 76))
}
     body{
        background: linear-gradient(rgb(46, 60, 60),rgb(204, 114, 114),teal,rgb(57, 53, 53));
    }
    h2.Name{
        color: darkOrange;
    
    }
  

    </style>
</head>
<body>
<form action="">
<div class="username">
<h1><span class="span">Welcome To Tapfoods</span> <%=request.getParameter("username")%></h1>

</div>

 <div class="container">
    <img class="name" src="T..........jpg" alt="Swasggiy">
    <h2>TapFoods</h2>
   
    <input type="text" id="search" name="q" placeholder="Search...">
    <!-- <button type="submit">Search</button> -->
    <a href="#">Search</a>

    <div class="motion-effect">
        <img class="login" src="user.png" alt="log">
        <a href="Login.jsp">Login</a>
        
        <img class="signup" src="Sign-Up-PNG-Royalty-Free-Image.png" alt="log">
        <a href="Signup.jsp">Signup</a>
        
        <img class="cart" src="CartImg.png" alt="log">
        <a href="Login.jsp">Cart</a>
    </div>
</div>

    <hr>
   
    <div class="hedder">
        <!-- <h1>Welcome to Tapfoods</h1> -->
    <div class="TapFoods"  >TapFoods</div>
        <img src="exploding-burger-with-vegetables-melted-cheese-black-background-generative-ai.jpg"alt="restaurant">
        <div class="text">TapFoods</div>
    </div>
    <h2>What's on your mind?</h2>
    <!-- 1stRow -->
    <div class="Restarunt-cont">

        <div class="restaurant">
            <img src="meals 1.avif"alt="restaurant1">
            <h5>Meals</h5>
        </div>

        <div class="restaurant">
            <img src="high-angle-tasty.jpg"alt="restaurant2">
            <h5>Chicken Tandoori</h5>
        </div>

        <div class="restaurant">
            <img src="close-up-appetizing-ramadan.avif"alt="restaurant1">
            <h5>Chicken Dum Biryani</h5>
        </div>

        <div class="restaurant">
            <img src="snacks.avif"alt="restaurant1">
            <h5>Snacks</h5>
        </div>
        <div class="restaurant">
            <img src="gourmet-chicken-biryani-with-steamed-basmati-rice-generated-by-ai_188544-13480.avif"alt="restaurant1">
            <h5>Biryani</h5>
        </div>
        <div class="restaurant">
            <img src="brown-coffee-droplets-fly.avif"alt="restaurant1">
            <h5>Coffee</h5>
        </div>
        <div class="restaurant">
            <img src="coolDrinks.jpg"alt="restaurant1">
            <h5>CoolDrinks</h5>
        </div>

        <div class="restaurant">
            <img src="taste-heaven.jpg"alt="restaurant1">
            <h5>Shavarama</h5>
        </div>

        <div class="restaurant">
            <img src="grilled-fish-barbecue.jpg"alt="restaurant1">
            <h5>Fish</h5>
        </div>
    </div>

    <h2>Top restaurant chains in Bangalore</h2>


       
    <div class="restarunt-container">
    <%
    List<Restaurant> list = (List<Restaurant>) request.getAttribute("restaurants");
    if(list != null){
        for(Restaurant res : list){
    %>
    <div class="restaurant">
        <a href="MenuServlet?restaurantId=<%= res.getRestaurantId() %>">
            <img src="<%= res.getImagePath() %>" alt="#">
            <h2 class="Name"><%= res.getName() %></h2>
<h2 class="rating-icon"></h2>
<h2><span>&star;</span> <%= res.getRatings() %> | <%= res.getEta() %>mins</h2>
            <p class="CuisineType"><%= res.getCuisineType() %></p>
            <p class="Address"><%= res.getAddress() %></p>
        </a>
    </div>
    <% } } %>
</div>


   
</form>

</body>
</html>