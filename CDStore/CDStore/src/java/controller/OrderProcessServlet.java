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
import service.Account;
import service.Order;

/**
 *
 * @author Fan
 */
public class OrderProcessServlet extends HttpServlet {

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
            if (service.equals("checkOut")) {
                //Session controller for account
                HttpSession session=request.getSession();
                Account account = (Account)session.getAttribute("account");
                ShoppingCart shopCart = (ShoppingCart) session.getAttribute("shopCart");

                if (session.getAttribute("i") == null) {
                    session.setAttribute("i", 0);
                }
                int i = (Integer) session.getAttribute("i") + 1;
                session.setAttribute("i", i);

                //System.out.println("i=" + i);
                String id = createOrder("PROCESSED", account.getId(), String.valueOf(shopCart.getSubtotal()), shopCart.getAllProductsFromCart());
                if (i % 5 == 0) {
                    confirmOrder(id, "DENIED");
                } else {
                    confirmOrder(id, "ORDERED");
                }
                ArrayList<Order> orders = getOrdersByAccountId(account.getId());
                request.setAttribute("orders", orders);

                RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
                rd.forward(request, response);
            } else if (service.equals("signin")) {
                //Session controller for account
                Account account = getAccount((String) request.getParameter("name"),
                        (String) request.getParameter("password"));
                if (account == null) {
                    request.setAttribute("errorMsg", "User name does not exist!");
                    RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response);
                } else {
                    HttpSession session=request.getSession();
                    session.setAttribute("account", account);
                    RequestDispatcher rd = request.getRequestDispatcher("/accountinfo.jsp");
                    rd.forward(request, response);
                }
            } else if (service.equals("signup")) {
                createAccount((String) request.getParameter("name"), (String) request.getParameter("password"),
                        (String) request.getParameter("lname"), (String) request.getParameter("fname"),
                        (String) request.getParameter("payment"), (String) request.getParameter("street"),
                        (String) request.getParameter("city"), (String) request.getParameter("province"),
                        (String) request.getParameter("zip"), (String) request.getParameter("phone"));

                request.setAttribute("errorMsg", "Create account successfully!");
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            } else if (service.equals("getAccountInfo")) {
                RequestDispatcher rd = request.getRequestDispatcher("/accountinfo.jsp");
                rd.forward(request, response);
            } else if (service.equals("getOrders")) {
                HttpSession session=request.getSession();
                Account account = (Account) session.getAttribute("account");
                ArrayList<Order> orders = getOrdersByAccountId(account.getId());
                request.setAttribute("orders", orders);
                RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("errorMsg", "Invalid Request");
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMsg", "Unknown Error: " + e.getStackTrace());
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static String createOrder(java.lang.String status, java.lang.String account, java.lang.String subtotal, java.util.List<service.Product> cds) {
        service.OrderProcessWS_Service service = new service.OrderProcessWS_Service();
        service.OrderProcessWS port = service.getOrderProcessWSPort();
        return port.createOrder(status, account, subtotal, cds);
    }

    private static void confirmOrder(java.lang.String id, java.lang.String status) {
        service.OrderProcessWS_Service service = new service.OrderProcessWS_Service();
        service.OrderProcessWS port = service.getOrderProcessWSPort();
        port.confirmOrder(id, status);
    }

    private static java.util.ArrayList<service.Order> getOrdersByAccountId(java.lang.String id) {
        service.OrderProcessWS_Service service = new service.OrderProcessWS_Service();
        service.OrderProcessWS port = service.getOrderProcessWSPort();
        return (ArrayList<service.Order>) port.getOrdersByAccountId(id);
    }

    private static Account getAccount(java.lang.String name, java.lang.String password) {
        service.OrderProcessWS_Service service = new service.OrderProcessWS_Service();
        service.OrderProcessWS port = service.getOrderProcessWSPort();
        return port.getAccount(name, password);
    }

    private static void createAccount(java.lang.String name, java.lang.String password,
            java.lang.String lname, java.lang.String fname, java.lang.String payment,
            java.lang.String street, java.lang.String city, java.lang.String province,
            java.lang.String zip, java.lang.String phone) {
        service.OrderProcessWS_Service service = new service.OrderProcessWS_Service();
        service.OrderProcessWS port = service.getOrderProcessWSPort();
        port.createAccount(name, password, lname, fname, payment, street, city, province, zip, phone);
    }
}
