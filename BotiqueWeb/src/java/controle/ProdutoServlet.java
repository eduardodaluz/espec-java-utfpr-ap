/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {
    
    ServletContext servletContext;
    ControleProduto controlProd;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        servletContext = getServletConfig().getServletContext();
        controlProd = new ControleProduto();
        String action = request.getParameter("action");
        if(action == null || action.equals("list")) {
            processList(request, response);
        } else {
            if(action.equals("edit")) {
                processEdit(request, response);
            } else if (action.equals("update")) {
                processUpdate(request, response);
            } else if (action.equals("add")) {
                processAdd(request, response);
            } else if (action.equals("save")) {
                processSave(request, response);
            } else if (action.equals("delete")) {
                processDelete(request, response);
            } else if (action.equals("search")) {
                processSearch(request, response);
            }
        }
    }
    
    private void processSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        List<Produto> produtoInstanceList = controlProd.listaDeProdutosPorDescricao(descricao);
        request.setAttribute("produtoInstanceList", produtoInstanceList);
        servletContext.getRequestDispatcher("/produto/list.jsp").forward(request, response);
    }
    
    private void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        controlProd.deletar(Integer.parseInt(request.getParameter("id")));
        processList(request, response);
    }
    
    private void processSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto prod = new Produto();
//        prod.setId(Integer.parseInt(request.getParameter("id")));
        prod.setDescricao(request.getParameter("descricao"));
        controlProd.inserir(prod);
        processList(request, response);
    }
    
    private void processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto();
        request.setAttribute("produto", produto);
        servletContext.getRequestDispatcher("/produto/add.jsp").forward(request, response);
    }
    
    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> produtoInstanceList = controlProd.listaDeProdutos();
        request.setAttribute("produtoInstanceList", produtoInstanceList);
        servletContext.getRequestDispatcher("/produto/list.jsp").forward(request, response);
    }
    
    private void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto prod = new Produto();
        prod.setId(Integer.parseInt(request.getParameter("id")));
        prod.setDescricao(request.getParameter("descricao"));
        controlProd.atualizar(prod);
        processList(request, response);
    }
    
    private void processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Produto produto = controlProd.getProduto(id);
        request.setAttribute("produto", produto);
        servletContext.getRequestDispatcher("/produto/edit.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
