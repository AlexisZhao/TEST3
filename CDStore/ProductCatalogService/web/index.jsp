<%-- 
    Document   : index
    Created on : 2013-10-5, 10:40:54
    Author     : Administrator
--%>

<%@page import="service.ProductCatalogService"%>
<%@page import="domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <%
    
	ProductCatalogService pcs = new ProductCatalogService();
        ArrayList<String> categories = new ArrayList<String>();
        Product product = new Product();;
        categories = pcs.getCategoryList();
        product = pcs.getProductInfo("cd002");
        for(String cate:categories)
            out.println(cate);
        out.println(product.getTitle());
	
    
    %>
    </body>
</html>
