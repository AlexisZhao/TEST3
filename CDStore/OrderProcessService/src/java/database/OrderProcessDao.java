package database;

import domain.Account;
import domain.Order;
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
public class OrderProcessDao {

    private DBAgent dbAgent = null;

    public OrderProcessDao() {
        this.dbAgent = new DBAgent();
    }

    public Account getAccountById(String id) {
        ResultSet rs = null;
        Account account = new Account();
        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetAccountById", id);
            account.setId(rs.getString("id"));
            account.setName(rs.getString("name"));
            account.setPassword(rs.getString("password"));
            account.setFname(rs.getString("fname"));
            account.setLname(rs.getString("lname"));
            account.setPayment(rs.getString("payment"));
            account.setStreet(rs.getString("street"));
            account.setCity(rs.getString("city"));
            account.setProvince(rs.getString("province"));
            account.setZip(rs.getString("zip"));
            account.setPhone(rs.getString("phone"));
        } catch (SQLException ex) {
            Logger.getLogger(OrderProcessDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return account;
    }

    public void insertAccount(Account account) {
        dbAgent.beginTransaction();
        dbAgent.executeSQL("InsertAccount", account.getName(),
                account.getPassword(), account.getFname(), account.getLname(),
                account.getPayment(), account.getStreet(), account.getCity(),
                account.getProvince(), account.getZip(), account.getPhone());
        // End the transaction
        dbAgent.endTransaction();
    }

    public void updateAccount(Account account) {
        dbAgent.beginTransaction();
        dbAgent.executeSQL("UpdateAccount", account.getName(),
                account.getPassword(), account.getFname(), account.getLname(),
                account.getPayment(), account.getStreet(), account.getCity(),
                account.getProvince(), account.getZip(), account.getPhone());
        // End the transaction
        dbAgent.endTransaction();
    }

    public Account authenticateAccount(String name, String password) {
        ResultSet rs = null;
        Account account = new Account();
        try {
            dbAgent.beginTransaction();
            System.out.println(name + "....." + password);
            rs = dbAgent.getQueryResult("AuthenticateAccount", name, password);
            if (!rs.next()) {
                System.out.println("authenticateAccount fails!");
                return null;
            } else {
                account.setId(rs.getString("id"));
                account.setName(rs.getString("name"));
                account.setPassword(rs.getString("password"));
                account.setFname(rs.getString("fname"));
                account.setLname(rs.getString("lname"));
                account.setPayment(rs.getString("payment"));
                account.setStreet(rs.getString("street"));
                account.setCity(rs.getString("city"));
                account.setProvince(rs.getString("province"));
                account.setZip(rs.getString("zip"));
                account.setPhone(rs.getString("phone"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return account;
    }

    public String insertOrder(String status, String account, String subtotal, ArrayList<Product> cds) {
        ResultSet rs = null;
        String id = null;
        dbAgent.beginTransaction();
        dbAgent.executeSQL("InsertOrder", status, account, subtotal);

        rs = dbAgent.getQueryResult("GetLastOrderIdByAccount", account);
        
        try {
            rs.next();
            System.out.println("Order id: "+rs.getString("subtotal"));
            id = rs.getString("id");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        for (Product cd : cds) {
            //dbAgent.executeSQL1("INSERT INTO poitem (order, cdid, price) VALUES ('5','"+cd.getCdid()+"', '"+String.valueOf(cd.getPrice())+"');");
            dbAgent.executeSQL("InsertOrderItems", id , cd.getCdid(), String.valueOf(cd.getPrice()));
        }
        // End the transaction
        dbAgent.endTransaction();
        return id;
    }

    public void updateOrderStatus(String status, String id) {
        dbAgent.beginTransaction();
        dbAgent.executeSQL("UpdateOrderStatus", status, id);
        // End the transaction
        dbAgent.endTransaction();
    }

    public ArrayList<Order> getOrdersByAccountId(String id) {
        System.out.println("Account ID: " + id);
        ResultSet rs = null;
        ArrayList<Order> orders = new ArrayList<Order>();
        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetOrdersByAccountId", id);

            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getString("id"));
                order.setAccount(rs.getString("account"));
                order.setStatus(rs.getString("status"));
                order.setSubtotal(rs.getString("subtotal"));
                orders.add(order);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return orders;
    }

    public String getLastOrderIdByAccount(String account) {
        ResultSet rs = null;
        String id = null;
        try {
            dbAgent.beginTransaction();
            rs = dbAgent.getQueryResult("GetLastOrderIdByAccount");
            id = rs.getString("id");

        } catch (SQLException ex) {
            Logger.getLogger(OrderProcessDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // End the transaction
            dbAgent.endTransaction();
        }
        return id;
    }
}
