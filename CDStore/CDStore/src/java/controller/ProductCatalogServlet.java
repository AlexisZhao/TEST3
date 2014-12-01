package controller;

import domain.ShoppingCart;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.Product;

/**
 * @author Fan
 */
public class ProductCatalogServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String service = request.getParameter("service");

            if (service == null || service.equals("")) {
                ArrayList<Product> cds = getAllProducts();
                ArrayList<String> categories = getCategoryList();
                request.setAttribute("cds", cds);
                request.setAttribute("categories", categories);
                RequestDispatcher rd = request.getRequestDispatcher("/cdstore.jsp");
                rd.forward(request, response);
            } else if (service.equals("getProductsByCategory")) {
                String cate = request.getParameter("cate");
                ArrayList<Product> cds = getProductsByCategory(cate);
                ArrayList<String> categories = new ArrayList<String>();
                categories.add(cate);
                request.setAttribute("cds", cds);
                request.setAttribute("categories", categories);
                RequestDispatcher rd = request.getRequestDispatcher("/cdstore.jsp");
                rd.forward(request, response);
            } else if (service.equals("getProductInfo")) {
                String cdid = request.getParameter("cdid");
                Product cd = getProductInfo(cdid);
                request.setAttribute("cd", cd);
                RequestDispatcher rd = request.getRequestDispatcher("/cdinfo.jsp");
                rd.forward(request, response);
            } else if (service.equals("showCart")) {
                //Session controller for shopping cart
                HttpSession  session=request.getSession();
                ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");
                if (shopCart == null) {
                    shopCart = new ShoppingCart();
                    session.setAttribute("shopCart", shopCart);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/shoppingcart.jsp");
                rd.forward(request, response);
            } else if (service.equals("addCart")) {
                //Session controller for shopping cart
                HttpSession session=request.getSession();
                ShoppingCart shopCart = (ShoppingCart)session.getAttribute("shopCart");
                if (shopCart == null) {
                    shopCart = new ShoppingCart();
                }
                String cdid = request.getParameter("cdid");
                Product cd = getProductInfo(cdid);
                shopCart.addProductToCart(cd);
                session.setAttribute("shopCart", shopCart);
                RequestDispatcher rd = request.getRequestDispatcher("/shoppingcart.jsp");
                rd.forward(request, response);
            } else if (service.equals("deleteItem")) {
                //Session controller for shopping cart
                HttpSession session=request.getSession();
                ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");
                String cdid = request.getParameter("cdid");
                shopCart.removeProductFromCart(cdid);
                session.setAttribute("shopCart", shopCart);
                RequestDispatcher rd = request.getRequestDispatcher("/shoppingcart.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("errorMsg", "Invalid Request");
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.print(e.toString());
            request.setAttribute("errorMsg", "Unknown Error: " + e.getStackTrace());
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            System.out.println(e.getMessage());
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected static java.util.ArrayList<service.Product> getAllProducts() {
        service.ProductCatalogWS_Service service = new service.ProductCatalogWS_Service();
        service.ProductCatalogWS port = service.getProductCatalogWSPort();
        return (ArrayList<Product>) port.getAllProducts();
    }

    private static java.util.ArrayList<java.lang.String> getCategoryList() {
        service.ProductCatalogWS_Service service = new service.ProductCatalogWS_Service();
        service.ProductCatalogWS port = service.getProductCatalogWSPort();
        return (ArrayList<String>) port.getCategoryList();
    }

    private static java.util.ArrayList<service.Product> getProductsByCategory(java.lang.String category) {
        service.ProductCatalogWS_Service service = new service.ProductCatalogWS_Service();
        service.ProductCatalogWS port = service.getProductCatalogWSPort();
        return (ArrayList<service.Product>) port.getProductsByCategory(category);
    }

    private static Product getProductInfo(java.lang.String cdid) {
        service.ProductCatalogWS_Service service = new service.ProductCatalogWS_Service();
        service.ProductCatalogWS port = service.getProductCatalogWSPort();
        return port.getProductInfo(cdid);
    }
}
