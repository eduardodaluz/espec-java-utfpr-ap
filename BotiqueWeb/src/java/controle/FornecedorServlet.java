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
import modelo.Fornecedor;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "FornecedorServlet", urlPatterns = {"/fornecedor"})
public class FornecedorServlet extends HttpServlet {
    
    ServletContext servletContext;
    ControleFornecedor controlForn;

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
        controlForn = new ControleFornecedor();
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
        String nome = request.getParameter("nome");
        List<Fornecedor> fornecedorInstanceList = controlForn.listaDeFonecedoresPorNome(nome);
        request.setAttribute("fornecedorInstanceList", fornecedorInstanceList);
        servletContext.getRequestDispatcher("/fornecedor/list.jsp").forward(request, response);
    }
    
    private void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        controlForn.deletar(Integer.parseInt(request.getParameter("id")));
        processList(request, response);
    }
    
    private void processSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fornecedor forn = new Fornecedor();
//        forn.setId(Integer.parseInt(request.getParameter("id")));
        forn.setNome(request.getParameter("nome"));
        forn.setTelefone(request.getParameter("telefone"));
        forn.setEmail(request.getParameter("email"));
        controlForn.inserir(forn);
        processList(request, response);
    }
    
    private void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fornecedor forn = new Fornecedor();
        forn.setId(Integer.parseInt(request.getParameter("id")));
        forn.setNome(request.getParameter("nome"));
        forn.setTelefone(request.getParameter("telefone"));
        forn.setEmail(request.getParameter("email"));
        controlForn.atualizar(forn);
        processList(request, response);
    }
    
    private void processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fornecedor fornecedor = new Fornecedor();
        request.setAttribute("fornecedor", fornecedor);
        servletContext.getRequestDispatcher("/fornecedor/add.jsp").forward(request, response);
    }
    
    private void processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Fornecedor fornecedor = controlForn.getFornecedor(id);
        request.setAttribute("fornecedor", fornecedor);
        servletContext.getRequestDispatcher("/fornecedor/edit.jsp").forward(request, response);
    }
    
    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Fornecedor> fornecedorInstanceList = controlForn.listaDeFornecedores();
        request.setAttribute("fornecedorInstanceList", fornecedorInstanceList);
        servletContext.getRequestDispatcher("/fornecedor/list.jsp").forward(request, response);
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
