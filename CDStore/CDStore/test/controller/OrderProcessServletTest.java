/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.ShoppingCart;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import service.Account;
import service.Order;
import service.Product;

/**
 *
 * @author sandy
 */
public class OrderProcessServletTest {
    
    
    public OrderProcessServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of processRequest method, of class OrderProcessServlet.
     */
        @Test
    public void testCheckOut() throws Exception {
      OrderProcessServlet servlet=new OrderProcessServlet();
      HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
      HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class); 
        
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("checkOut");
       
       HttpSession session = EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       
       Account act=EasyMock.createMock(Account.class);
       EasyMock.expect((Account)session.getAttribute("account")).andReturn(act);
       
       ShoppingCart shopCart=EasyMock.createMock(ShoppingCart.class);
       EasyMock.expect((ShoppingCart)session.getAttribute("shopCart")).andReturn(shopCart);
       
       EasyMock.expect(session.getAttribute("i")).andReturn(0).times(2);
       session.setAttribute(EasyMock.eq("i"), EasyMock.anyObject());
       
       EasyMock.expect(act.getId()).andReturn("1").times(2);
       EasyMock.expect(shopCart.getSubtotal()).andReturn(100);
       
       ArrayList<Product> proList=new ArrayList<Product>();
       Product cd=new Product();
       cd.setCategory("COUNTRY");
       cd.setCdid("cd006");
       cd.setPrice(100);
       cd.setTitle("CT");
       proList.add(cd);
       
       EasyMock.expect(shopCart.getAllProductsFromCart()).andReturn(proList);       
       mockReq.setAttribute(EasyMock.eq("orders"), (ArrayList<Order>)EasyMock.anyObject());

       EasyMock.expect(mockReq.getRequestDispatcher("/order.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       EasyMock.replay(act);
       EasyMock.replay(shopCart);


       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
       EasyMock.verify(act);
       EasyMock.verify(shopCart);

    }
    @Test
    public void testSignIn() throws Exception {
      OrderProcessServlet servlet=new OrderProcessServlet();
      HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
      HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class); 
        
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("signin");
       EasyMock.expect(mockReq.getParameter("name")).andReturn("Fan");
       EasyMock.expect(mockReq.getParameter("password")).andReturn("admin");
       
       HttpSession session = EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       session.setAttribute(EasyMock.eq("account"),(Account) EasyMock.anyObject());
       EasyMock.expect(mockReq.getRequestDispatcher("/accountinfo.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
    }
    @Test
    public void testSignUp() throws Exception {
      OrderProcessServlet servlet=new OrderProcessServlet();
      HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
      HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
              
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("signup");
       EasyMock.expect(mockReq.getParameter("name")).andReturn("Fan");
       EasyMock.expect(mockReq.getParameter("password")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("lname")).andReturn("Fan");
       EasyMock.expect(mockReq.getParameter("fname")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("payment")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("street")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("city")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("province")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("zip")).andReturn("admin");
       EasyMock.expect(mockReq.getParameter("phone")).andReturn("admin");
              
       mockReq.setAttribute(EasyMock.eq("errorMsg"),EasyMock.eq("Create account successfully!"));
       EasyMock.expect(mockReq.getRequestDispatcher("/error.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
    }

    @Test
    public void testGetAccountInfo() throws Exception {
      OrderProcessServlet servlet=new OrderProcessServlet();
      HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
      HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
              
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("getAccountInfo");

       EasyMock.expect(mockReq.getRequestDispatcher("/accountinfo.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
    }
    
        @Test
    public void testGetOrder() throws Exception {
      OrderProcessServlet servlet=new OrderProcessServlet();
      HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
      HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
      
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("getOrders");
       HttpSession session=EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       Account act=EasyMock.createMock(Account.class);
       EasyMock.expect(session.getAttribute("account")).andReturn(act);
       EasyMock.expect(act.getId()).andReturn("1");
       mockReq.setAttribute(EasyMock.eq("orders"),(ArrayList<Order>) EasyMock.anyObject());

       EasyMock.expect(mockReq.getRequestDispatcher("/order.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       EasyMock.replay(act);
     
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
       EasyMock.verify(act);
   }
 }
