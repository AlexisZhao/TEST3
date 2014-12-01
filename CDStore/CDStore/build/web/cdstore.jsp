<%@page import="service.Product"%>
<%@page import="java.util.ArrayList"%>
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
                <div class="body">
                    <div class="portfolio">
                        <h2>Accelerated CD Store</h2>
                        <ul class="navigation">
                            <li>
                                <a href="./ProductCatalog?service=showCart">Shopping Cart</a>
                            </li>
                            <li>
                                <a href="signin.jsp">Sign In</a>
                            </li>
                            <li>
                                <a href="signup.jsp">Sign Up</a>
                            </li>
                        </ul>
                        <h3><span>CD Category</span></h3>
                        <ul>
                            <%
                                ArrayList<String> categories = (ArrayList) request.getAttribute("categories");
                                for (String cate: categories) {                      
                            %>
                            <li>
                                <a href="./ProductCatalog?service=getProductsByCategory&cate=<%=cate%>"><img src="images/icon_cd.jpg" alt=""></a> <a href="#"><%=cate%></a>
                            </li>
                            <%}%>

                        </ul>
                        <h3><span>CD</span></h3>
                        <ul>
                            <%
                                ArrayList<Product> cds = (ArrayList) request.getAttribute("cds");
                                int i = 1;
                                for (Product cd: cds) {
                            %>
                            <li>
                                <a href="./ProductCatalog?service=getProductInfo&cdid=<%=cd.getCdid()%>"><img src="images/logo<%=i%>.jpg" alt=""></a> <span><%=cd.getTitle()%></span> <a href="./ProductCatalog?service=addCart&cdid=<%=cd.getCdid()%>">Add to Shopping Cart</a>
                            </li>
                            <%i++;}%>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
