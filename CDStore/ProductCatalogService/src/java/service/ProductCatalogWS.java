/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.ProductCatalogDao;
import domain.Product;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fan
 */
@WebService(serviceName = "ProductCatalogWS")
public class ProductCatalogWS {

    @WebMethod(operationName = "getCategoryList")
    public ArrayList<String> getCategoryList() {
        ProductCatalogDao dao = new ProductCatalogDao();
        ArrayList<String> categorylist = dao.getCategoryList();
        return categorylist;
    }

    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "cdid") String cdid) {
        ProductCatalogDao dao = new ProductCatalogDao();
        Product cd = dao.getProductInfo(cdid);
        return cd;
    }

    @WebMethod(operationName = "getProductsByCategory")
    public ArrayList<Product> getProductsByCategory(@WebParam(name = "category") String category) {
        ProductCatalogDao dao = new ProductCatalogDao();
        ArrayList<Product> cdlist = dao.getProductsByCategory(category);
        return cdlist;
    }

    @WebMethod(operationName = "getAllProducts")
    public ArrayList<Product> getAllProducts() {
        ProductCatalogDao dao = new ProductCatalogDao();
        ArrayList<Product> cdlist = dao.getAllProducts();
        return cdlist;
    }
}
