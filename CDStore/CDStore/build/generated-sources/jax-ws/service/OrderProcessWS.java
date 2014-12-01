
package service;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OrderProcessWS", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OrderProcessWS {


    /**
     * 
     * @param id
     * @return
     *     returns java.util.List<service.Order>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getOrdersByAccountId", targetNamespace = "http://service/", className = "service.GetOrdersByAccountId")
    @ResponseWrapper(localName = "getOrdersByAccountIdResponse", targetNamespace = "http://service/", className = "service.GetOrdersByAccountIdResponse")
    @Action(input = "http://service/OrderProcessWS/getOrdersByAccountIdRequest", output = "http://service/OrderProcessWS/getOrdersByAccountIdResponse")
    public List<Order> getOrdersByAccountId(
        @WebParam(name = "id", targetNamespace = "")
        String id);

    /**
     * 
     * @param status
     * @param cds
     * @param account
     * @param subtotal
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createOrder", targetNamespace = "http://service/", className = "service.CreateOrder")
    @ResponseWrapper(localName = "createOrderResponse", targetNamespace = "http://service/", className = "service.CreateOrderResponse")
    @Action(input = "http://service/OrderProcessWS/createOrderRequest", output = "http://service/OrderProcessWS/createOrderResponse")
    public String createOrder(
        @WebParam(name = "status", targetNamespace = "")
        String status,
        @WebParam(name = "account", targetNamespace = "")
        String account,
        @WebParam(name = "subtotal", targetNamespace = "")
        String subtotal,
        @WebParam(name = "cds", targetNamespace = "")
        List<Product> cds);

    /**
     * 
     * @param id
     * @param status
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "confirmOrder", targetNamespace = "http://service/", className = "service.ConfirmOrder")
    @Action(input = "http://service/OrderProcessWS/confirmOrder")
    public void confirmOrder(
        @WebParam(name = "id", targetNamespace = "")
        String id,
        @WebParam(name = "status", targetNamespace = "")
        String status);

    /**
     * 
     * @param name
     * @param password
     * @return
     *     returns service.Account
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccount", targetNamespace = "http://service/", className = "service.GetAccount")
    @ResponseWrapper(localName = "getAccountResponse", targetNamespace = "http://service/", className = "service.GetAccountResponse")
    @Action(input = "http://service/OrderProcessWS/getAccountRequest", output = "http://service/OrderProcessWS/getAccountResponse")
    public Account getAccount(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param zip
     * @param phone
     * @param lname
     * @param payment
     * @param street
     * @param name
     * @param province
     * @param password
     * @param fname
     * @param city
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "createAccount", targetNamespace = "http://service/", className = "service.CreateAccount")
    @Action(input = "http://service/OrderProcessWS/createAccount")
    public void createAccount(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "lname", targetNamespace = "")
        String lname,
        @WebParam(name = "fname", targetNamespace = "")
        String fname,
        @WebParam(name = "payment", targetNamespace = "")
        String payment,
        @WebParam(name = "street", targetNamespace = "")
        String street,
        @WebParam(name = "city", targetNamespace = "")
        String city,
        @WebParam(name = "province", targetNamespace = "")
        String province,
        @WebParam(name = "zip", targetNamespace = "")
        String zip,
        @WebParam(name = "phone", targetNamespace = "")
        String phone);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://service/", className = "service.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://service/", className = "service.HelloResponse")
    @Action(input = "http://service/OrderProcessWS/helloRequest", output = "http://service/OrderProcessWS/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
