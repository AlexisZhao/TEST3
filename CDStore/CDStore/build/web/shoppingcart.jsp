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
                    ShoppingCart shopCart = (ShoppingCart) request.getSession().getAttribute("shopCart");
                    ArrayList<Product> cartItmes = shopCart.getAllProductsFromCart();
                %>
                <div class="body">
                    <div class="services">
                        <h2>Shopping Cart</h2>
                        <ul class="navigation">
                            <li>
                                <a href="./OrderProcess?service=checkOut">Check Out</a>
                            </li>    
                        </ul>
                        <ul>
                        <table border="5">
                            <tr>
                                <caption>Subtotal: <%=shopCart.getSubtotal()%></caption>
                                <th>CD ID</th>
                                <th>CD Title</th>
                                <th>CD Category</th>
                                <th>CD Price</th>
                                <th>Operation</th>
                            </tr>
                            <%
                                for (int i = 0; cartItmes != null && i < cartItmes.size(); i++) {
                                    Product item = (Product) cartItmes.get(i);
                            %>
                            <tr>
                                <td><%=item.getCdid()%></td>
                                <td><%=item.getTitle()%></td>
                                <td><%=item.getCategory()%></td>
                                <td><%=item.getPrice()%></td>
                                <td><a href="./ProductCatalog?service=deleteItem&cdid=<%=item.getCdid()%>">Delete</a></td>
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