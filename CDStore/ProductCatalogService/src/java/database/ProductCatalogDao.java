/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import domain.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fan
 */
public class ProductCatalogDao {

    private DBAgent dbAgent = null;

    public ProductCatalogDao() {
        this.dbAgent = new DBAgent();
    }

    public ArrayList<String> getCategoryList() {
        ResultSet rs = null;
        ArrayList<String> categorylist = new ArrayList<String>();
        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetCategories");
            while (rs.next()) {
                categorylist.add(rs.getString("category"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductCatalogDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return categorylist;
    }

    public Product getProductInfo(String cdid) {
        ResultSet rs = null;
        Product cd = new Product();
        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetProductById", cdid);
            if (rs.next()) {
                cd.setCdid(rs.getString("cdid"));
                cd.setTitle(rs.getString("title"));
                cd.setCategory(rs.getString("category"));
                cd.setPrice(Integer.parseInt(rs.getString("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return cd;
    }

    public ArrayList<Product> getProductsByCategory(String category) {
        ResultSet rs = null;
        ArrayList<Product> cdlist = new ArrayList<Product>();

        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetProductsByCategory", category);
            while (rs.next()) {
                Product cd = new Product();
                cd.setCdid(rs.getString("cdid"));
                cd.setTitle(rs.getString("title"));
                cd.setCategory(rs.getString("category"));
                cd.setPrice(Integer.parseInt(rs.getString("price")));
                cdlist.add(cd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return cdlist;
    }

    public ArrayList<Product> getAllProducts() {
        ResultSet rs = null;
        ArrayList<Product> cdlist = new ArrayList<Product>();

        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetProducts");
            while (rs.next()) {
                Product cd = new Product();
                cd.setCdid(rs.getString("cdid"));
                cd.setTitle(rs.getString("title"));
                cd.setCategory(rs.getString("category"));
                cd.setPrice(Integer.parseInt(rs.getString("price")));
                cdlist.add(cd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return cdlist;
    }
}
