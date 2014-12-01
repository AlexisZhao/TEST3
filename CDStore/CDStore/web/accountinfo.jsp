<%@page import="service.Account"%>
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
                    Account account = (Account)request.getSession().getAttribute("account");
                %>
                <div class="body">
                    <div class="services">
                        <h2>My Account</h2>  
                        <ul>
                            <li>
                                <p>
                                    Name: <%=account.getName()%>
                                </p>
                                <p>
                                    Password: <%=account.getPassword()%>
                                </p>
                                <p>
                                    First Name: <%=account.getFname()%>
                                </p>
                                <p>
                                    Last Name: <%=account.getLname()%>
                                </p>
                                <p>
                                    Credit Card: <%=account.getPayment()%>
                                </p>
                                <p>
                                    Street: <%=account.getStreet()%>
                                </p>
                                <p>
                                    City: <%=account.getCity()%>
                                </p>
                                <p>
                                    Province: <%=account.getProvince()%>
                                </p>
                                <p>
                                    Zip: <%=account.getZip()%>
                                </p>
                                <p>
                                    Phone: <%=account.getPhone()%>
                                </p>
                                
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>