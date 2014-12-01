<%@page import="service.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.ShoppingCart"%>
<%@page import="service.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Accelerated CD Store</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <div class="border">
            <div id="bg">
                background
            </div>
            <div class="page">
                <div class="sidebar">
                    <a href="index.html" id="logo"><img src="images/logo.png" alt="logo"></a>
                    <ul>
                        <li class="selected">
                            <a href="./ProductCatalog">CD Store</a>
                        </li>
                        <li>
                            <a href="./OrderProcess?service=getAccountInfo">Account Info</a>
                        </li>
                        <li>
                            <a href="./OrderProcess?service=getOrders">My Orders</a>
                        </li>

                    </ul>

                    <div class="connect">
                        <a href="#" id="facebook">facebook</a> <a href="#" id="twitter">twitter</a> <a href="#" id="googleplus">youtube</a>
                    </div>
                    <p>
                        Copyright 2013
                    </p>
                    <p>
                        Accelerated CD Store
                    </p>
                </div>
                <%
                    ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("orders");
                %>
                <div class="body">
                    <div class="services">
                        <h2>My Orders</h2>
                        <ul>
                        <table border="5">
                            <tr>
                                <th>Order Id</th>
                                <th>Order Status</th>
                                <th>Subtotal</th>
                            </tr>
                            <%
                                for (Order order: orders) {
                            %>
                            <tr>
                                <td><%=order.getId()%></td>
                                <td><%=order.getStatus()%></td>
                                <td><%=order.getSubtotal()%></td>
                            </tr>
                            <%}%>
                        </table>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>