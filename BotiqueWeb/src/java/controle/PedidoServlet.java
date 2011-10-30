package controle;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pedido;
import modelo.PedidoItem;

/**
 *
 * @author eduardo
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedido"})
public class PedidoServlet extends HttpServlet {
    
    ServletContext servletContext;
    ControlePedido controlPed;

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
        controlPed = new ControlePedido();
        String action = request.getParameter("action");
        if(action == null || action.equals("list")) {
            processList(request, response);
        } else {
            if(action.equals("edit")) {
                processEdit(request, response);
            } else if (action.equals("update")) {
                processUpdate(request, response);
            }  else if (action.equals("add")) {
                processAdd(request, response);
            } else if (action.equals("save")) {
                processSave(request, response);
            } else if (action.equals("delete")) {
                processDelete(request, response);
//            } else if (action.equals("search")) {
//                processSearch(request, response);
            }
        }
    }
    
    private void processDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        controlPed.deletar(Integer.parseInt(request.getParameter("id")));
        processList(request, response);
    }
    
    private void processSave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pedido pedido = new Pedido();
        pedido.setNumero(Integer.parseInt(request.getParameter("numero")));
        pedido.setDtPedido(Date.valueOf(request.getParameter("dtPedido")));
        pedido.setFornecedor(controlPed.getFornecedor(Integer.valueOf(request.getParameter("fornecedor.id"))));
        int i = 1;
        List<PedidoItem> itens = new ArrayList<PedidoItem>();
        pedido.setPedidoItens(null);
        while(request.getParameter("item["+i+"].exists") != null) {
            System.out.println("Item: " + request.getParameter("item["+i+"].exists"));
            PedidoItem item = new PedidoItem();
            item.setQuantidade(Double.valueOf(request.getParameter("item["+i+"].quantidade")));
            item.setProduto(controlPed.getProduto(Integer.parseInt(request.getParameter("item["+i+"].produto"))));
            itens.add(item);
            i++;
        }
        pedido.setPedidoItens(itens);
        controlPed.inserir(pedido);
        processList(request, response);
    }
    
    private void processAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pedido pedido = new Pedido();
        request.setAttribute("pedido", pedido);
        request.setAttribute("fornecedorInstanceList", controlPed.listaDeFornecedores());
        request.setAttribute("produtoInstanceList", controlPed.listaDeProdutos());
        servletContext.getRequestDispatcher("/pedido/add.jsp").forward(request, response);
    }
    
    private void processUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Pedido pedido = controlPed.getPedido(Integer.parseInt(request.getParameter("id")));
        pedido.setNumero(Integer.parseInt(request.getParameter("numero")));
        pedido.setDtPedido(Date.valueOf(request.getParameter("dtPedido")));
        pedido.setFornecedor(controlPed.getFornecedor(Integer.valueOf(request.getParameter("fornecedor.id"))));
        List<PedidoItem> itens = new ArrayList<PedidoItem>();
        int i = 1;
        pedido.setPedidoItens(null);
        while(request.getParameter("item["+i+"].exists") != null) {
            System.out.println("Item: " + request.getParameter("item["+i+"].exists"));
            PedidoItem item = new PedidoItem();
            item.setQuantidade(Double.valueOf(request.getParameter("item["+i+"].quantidade")));
            item.setProduto(controlPed.getProduto(Integer.parseInt(request.getParameter("item["+i+"].produto"))));
            itens.add(item);
            i++;
        }
        pedido.setPedidoItens(itens);
        controlPed.atualizar(pedido);
        processList(request, response);
    }
    
    private void processEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = controlPed.getPedido(id);
        request.setAttribute("pedido", pedido);
        request.setAttribute("fornecedorInstanceList", controlPed.listaDeFornecedores());
        request.setAttribute("produtoInstanceList", controlPed.listaDeProdutos());
        servletContext.getRequestDispatcher("/pedido/edit.jsp").forward(request, response);
    }
    
    private void processList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> pedidoInstanceList = controlPed.listaDePedidos();
        request.setAttribute("pedidoInstanceList", pedidoInstanceList);
        servletContext.getRequestDispatcher("/pedido/list.jsp").forward(request, response);
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
