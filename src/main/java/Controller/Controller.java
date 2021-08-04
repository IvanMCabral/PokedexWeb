package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.pokedex.ec.bo.PokemonBO;
import com.pokedex.ec.entity.Pokemon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class Controller extends HttpServlet {

    PokemonBO pbo = new PokemonBO();
    String list = "views/list.jsp";
    String add = "views/add.jsp";
    String edit = "views/edit.jsp";
    String modify = "views/modify.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String access = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("list")) {
            access = list;
        } else if (action.equalsIgnoreCase("add")) {
            access = add;
        } else if (action.equalsIgnoreCase("modify")) {
            access = modify;

        } else if (action.equalsIgnoreCase("Add Pokemon")) {
            Pokemon p = new Pokemon();
            String name = request.getParameter("name");
            p.setName(name);
            String type = request.getParameter("type");
            p.setType(type);
            String type2 = request.getParameter("type2");
            p.setType2(type2);
            p.setLevel(Integer.parseInt(request.getParameter("level")));
            String user = request.getParameter("user");
            p.setUser(user);

            String message = pbo.addPokemon(p);

            if (message == "New Pokemon Inserted!!") {
                access = list;
            }

            System.out.println("paso por aca");

        }

        RequestDispatcher view = request.getRequestDispatcher(access);
        view.forward(request, response);
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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

}
