<%@page import="service.Product"%>
<!DOCTYPE html>
<!-- Website template form http://www.cssmoban.com/ -->
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
                    Product cd = (Product) request.getAttribute("cd");
                %>
                <div class="body">
                    <div class="services">
                        <h2>CD Information</h2>
                        <ul class="navigation">
                            <li>
                                <a href="./ProductCatalog?service=addCart&cdid=<%=cd.getCdid()%>">Add to Shopping Cart</a>
                            </li>    
                        </ul>
                        <ul>
                            <li>
                                <div>
                                    <img src="images/logo5.jpg" alt="">
                                </div>

                                <p>
                                    Title: <%=cd.getTitle()%>
                                </p>
                                <p>
                                    Price: <%=cd.getPrice()%>
                                </p>
                                <p>
                                    Categoty: <%=cd.getCategory()%>
                                </p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>