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
import service.Product;

/**
 *
 * @author sandy
 */
public class ProductCatalogServletTest {


    //private static ServletTester tester;
    public ProductCatalogServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {

    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        //tester.stop();
    
    }

    /**
     * Test of processRequest method, of class ProductCatalogServlet.
     */
    @Test
    public void testGetAllCD() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("");
       mockReq.setAttribute(EasyMock.eq("cds"),(ArrayList<Product>) EasyMock.anyObject());
       mockReq.setAttribute(EasyMock.eq("categories"),(ArrayList<String>) EasyMock.anyObject());
       EasyMock.expect(mockReq.getRequestDispatcher("/cdstore.jsp")).andReturn(dispatcher);
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
    public void testGetCatalog() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("getProductsByCategory");
       EasyMock.expect(mockReq.getParameter("cate")).andReturn("COUNTRY");

       mockReq.setAttribute(EasyMock.eq("cds"),(ArrayList<Product>) EasyMock.anyObject());
       mockReq.setAttribute(EasyMock.eq("categories"),(ArrayList<String>) EasyMock.anyObject());
       EasyMock.expect(mockReq.getRequestDispatcher("/cdstore.jsp")).andReturn(dispatcher);
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
    public void testProductInfo() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("getProductInfo");
       EasyMock.expect(mockReq.getParameter("cdid")).andReturn("cd001");

       mockReq.setAttribute(EasyMock.eq("cd"),(ArrayList<Product>) EasyMock.anyObject());
       EasyMock.expect(mockReq.getRequestDispatcher("/cdinfo.jsp")).andReturn(dispatcher);
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
    public void testShowCart() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("showCart");
       HttpSession session = EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       ShoppingCart shopCart=(ShoppingCart)EasyMock.createMock(ShoppingCart.class);
       EasyMock.expect(session.getAttribute("shopCart")).andReturn(shopCart);
       if(shopCart!=null)
       {
             mockReq.setAttribute(EasyMock.eq("shopCart"),EasyMock.eq(shopCart));
       }
       EasyMock.expect(mockReq.getRequestDispatcher("/shoppingcart.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       EasyMock.replay(shopCart);
       
       servlet.doGet(mockReq, mockResp);
       
       //EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
       EasyMock.verify(shopCart);
    }

    @Test
    public void testaddCart() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("addCart");
       HttpSession session = EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       ShoppingCart shopCart=(ShoppingCart)EasyMock.createMock(ShoppingCart.class);
       
       EasyMock.expect(session.getAttribute("shopCart")).andReturn(shopCart);
       if (shopCart == null) {
            shopCart = new ShoppingCart();
       }
       EasyMock.expect(mockReq.getParameter("cdid")).andReturn("cd001");
       shopCart.addProductToCart((Product) EasyMock.anyObject());
       session.setAttribute("shopCart", shopCart);
       EasyMock.expect(mockReq.getRequestDispatcher("/shoppingcart.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       EasyMock.replay(shopCart);
       
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
       EasyMock.verify(shopCart);
    }
    
                    @Test
    public void testDelectItem() throws Exception {
       ProductCatalogServlet servlet=new ProductCatalogServlet();
       HttpServletRequest mockReq=EasyMock.createMock(HttpServletRequest.class);
       HttpServletResponse mockResp=EasyMock.createMock(HttpServletResponse.class);
       RequestDispatcher dispatcher=EasyMock.createMock(RequestDispatcher.class);
       EasyMock.expect(mockReq.getParameter("service")).andReturn("deleteItem");
       HttpSession session = EasyMock.createMock(HttpSession.class);
       EasyMock.expect(mockReq.getSession()).andReturn(session);
       ShoppingCart shopCart=(ShoppingCart)EasyMock.createMock(ShoppingCart.class);
       
       EasyMock.expect(session.getAttribute("shopCart")).andReturn(shopCart);
       EasyMock.expect(mockReq.getParameter("cdid")).andReturn("cd001");
       
       shopCart.removeProductFromCart( (String) EasyMock.anyObject());
       session.setAttribute("shopCart", shopCart);
       EasyMock.expect(mockReq.getRequestDispatcher("/shoppingcart.jsp")).andReturn(dispatcher);
       dispatcher.forward(mockReq, mockResp);
       
       EasyMock.replay(mockReq);
       EasyMock.replay(mockResp);  
       EasyMock.replay(dispatcher);
       EasyMock.replay(session);
       EasyMock.replay(shopCart);
       
       servlet.doGet(mockReq, mockResp);
       
       EasyMock.verify(mockReq);
       EasyMock.verify(mockResp);
       EasyMock.verify(dispatcher);
       EasyMock.verify(session);
       EasyMock.verify(shopCart);
    }
}