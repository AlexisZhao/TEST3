/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import database.OrderProcessDao;
import domain.Account;
import domain.Order;
import domain.Product;
import java.util.ArrayList;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "OrderProcessWS")
public class OrderProcessWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "createOrder")
    public String createOrder(@WebParam(name = "status") String status, @WebParam(name = "account") String account, @WebParam(name = "subtotal") String subtotal, @WebParam(name = "cds") ArrayList<Product> cds) {
        OrderProcessDao dao = new OrderProcessDao();
        String id = dao.insertOrder(status, account, subtotal, cds);
        return id;
    }

   
    @WebMethod(operationName = "createAccount")
    @Oneway
    public void createAccount(@WebParam(name = "name") String name, @WebParam(name = "password") String password, @WebParam(name = "lname") String lname, @WebParam(name = "fname") String fname, @WebParam(name = "payment") String payment, @WebParam(name = "street") String street, @WebParam(name = "city") String city, @WebParam(name = "province") String province, @WebParam(name = "zip") String zip, @WebParam(name = "phone") String phone) {
        OrderProcessDao dao = new OrderProcessDao();
        Account account = new Account();
        account.setName(name);
        account.setPassword(password);
        account.setFname(fname);
        account.setLname(lname);
        account.setPayment(payment);
        account.setStreet(street);
        account.setCity(city);
        account.setProvince(province);
        account.setZip(zip);
        account.setPhone(phone);
        dao.insertAccount(account);
    }

   
    @WebMethod(operationName = "getAccount")
    public Account getAccount(@WebParam(name = "name") String name, @WebParam(name = "password") String password) {
        OrderProcessDao dao = new OrderProcessDao();
        Account account = dao.authenticateAccount(name, password);
        return account;
    }

    @WebMethod(operationName = "confirmOrder")
    @Oneway
    public void confirmOrder(@WebParam(name = "id") String id, @WebParam(name = "status") String status) {
        OrderProcessDao dao = new OrderProcessDao();
        dao.updateOrderStatus(status, id);
    }

 
    @WebMethod(operationName = "getOrdersByAccountId")
    public ArrayList<Order> getOrdersByAccountId(@WebParam(name = "id") String id) {
        OrderProcessDao dao = new OrderProcessDao();
        ArrayList<Order> orders = dao.getOrdersByAccountId(id);
        return orders;
    }
}
