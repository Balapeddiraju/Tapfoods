<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import=java.util.List,com.tap.model.OrderItems" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>cart page</title>
<link rel="icon" herf="impl.png">
</head>
<body style="background-color:orange">
<div style ="backgeound-image:radial-gradent(oirole,lightgreen,white,orange);margin-left:300px;text-align:center;margin-top:80px;border:2px solid black;border-radius:50px;opacity:90%;"></div>
<h1>Restaurat menu</h1>
<%----Display menu items here-----%>
<hr>
<h2>Cart</h2>
<%--Display cart ieams here --%>

<%
List<OrderItems> cartItems =(List<OrderItems>) session.getAttribute("cart");
if(cartItems !=null && !cartItems.isEmpty()){
	double totalPrice =0.0;
	int resid =0;
%>
   <table border="1" style="margin-left:110px;color:black;">
   <tr>
     <th>Name</th>
     <th>price</th>
     <th>quantity</th>
     <th>Action</th>
   </tr>
   <% for(OrderItems  cartItem : cartItems) {
	   totalPrice += cartItem.getPrice() * cartItem.getQuantity();
	   resid = cartItem.getUserId();//restaurantId;
   %>
     <tr>
        <td><%=cartItem.getName() %></td>
         <td><%=cartItem.getPrice() %></td>
         <td>
           <form action=updatecart" method="post">
             <input type="hidden" name="menuId" value="<%=cartItem.getMenuId() %>">
              <input type="number" name="Quantity" value="<%= cartItem.getQuantity() %>">
             <button type ="submit">update</button>
           
           </form>
         </td>
         <td>
          <form action="removefromcart" method="post">
           <input type="hidden" name="menuId" value=<%=cartItem.getMenuId() %>">
           <button type ="remove">Remove</button>
          </form>
         </td>
     </tr>
     <% } %>
     </table>
     <hr>
     <h3>Total Price: <%= totalPrice %></h3>
     <a href="restaurants?restaurantId=<%=resid %>"> <button type="hidden">Go back to menu</button></a>
     <a href="?"><button type="hidden">checkout</button></a>
     
     <%
       }else{
     %>
     <p>Your cart is empty.</p>
     <% 
       }
     %>
  </div>
</body>
</html>