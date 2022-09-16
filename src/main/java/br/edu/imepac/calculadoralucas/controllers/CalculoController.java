package br.edu.imepac.calculadoralucas.controllers;


import br.edu.imepac.calculadoralucas.entities.Divisao;
import br.edu.imepac.calculadoralucas.entities.Multiplicacao;
import br.edu.imepac.calculadoralucas.entities.Soma;
import br.edu.imepac.calculadoralucas.entities.Subtracao;
import br.edu.imepac.calculadoralucas.interfaces.Calculadora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
@WebServlet(name = "CalculoController", urlPatterns = {"/Calculo"})
public class CalculoController extends HttpServlet {

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
            out.println("<html><head></head><body onload=\"alert('ERRO, Primeiramente digite os números e clique no botão ENVIAR!')\"></body></html>");
            out.println("<meta http-equiv='refresh' content='0.1; URL=index.html'>");
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {

            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<head><title>Calculo TDE 1 Lucas</title></head>");
            out.println("<body>");
            out.println("<fieldset style = \"width: 20%; margin: 0px auto; text-align:center; background-color:gainsboro; border-radius:5px; \">");
            if ("soma".equals(request.getParameter("operacao"))) {                
                Calculadora calcula = new Soma();            
                out.println("<h1 style=\"text-align:center; background-color:darkslategray; color: white; border-radius:5px;\">Soma</h1>");
                out.println("<fieldset style = \"background-color: honeydew; border-radius:5px;\">");
                out.println("<p style=\"text-align:center\"><b>" + num1 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">+</h2>");
                out.println("<p style=\"text-align:center\"><b>" + num2 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">=</h2>");
                out.println("<h1 style=\"text-align:center\">" + calcula.CalculaOperacao(num1, num2) + "</h1>");
                
            } else if ("subtracao".equals(request.getParameter("operacao"))) {               
                Calculadora calcula = new Subtracao();
                out.println("<h1 style=\"text-align:center; background-color:darkslategray; color: white; border-radius:5px;\">Subtração</h1>");
                out.println("<fieldset style = \"background-color: honeydew; border-radius:5px;\">");
                out.println("<p style=\"text-align:center\"><b>" + num1 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">-</h2>");
                out.println("<p style=\"text-align:center\"><b>" + num2 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">=</h2>");
                out.println("<h1 style=\"text-align:center\">" + calcula.CalculaOperacao(num1, num2) + "</h1>");
                
            }else if ("multiplicacao".equals(request.getParameter("operacao"))) {
                Calculadora calcula = new Multiplicacao();
                out.println("<h1 style=\"text-align:center; background-color:darkslategray; color: white; border-radius:5px;\">Multiplicação</h1>");
                out.println("<fieldset style = \"background-color: honeydew; border-radius:5px;\">");
                out.println("<p style=\"text-align:center\"><b>" + num1 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">*</h2>");
                out.println("<p style=\"text-align:center\"><b>" + num2 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">=</h2>");
                out.println("<h1 style=\"text-align:center\">" + calcula.CalculaOperacao(num1, num2) + "</h1>");
                
            }else if ("divisao".equals(request.getParameter("operacao"))) {
                Calculadora calcula = new Divisao();
                out.println("<h1 style=\"text-align:center; background-color:darkslategray; color: white; border-radius:5px;\">Divisão</h1>");
                out.println("<fieldset style = \"background-color: honeydew; border-radius:5px;\">");
                out.println("<p style=\"text-align:center\"><b>" + num1 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">/</h2>");
                out.println("<p style=\"text-align:center\"><b>" + num2 + "</b></p>");
                out.println("<h2 style=\"text-align:center\">=</h2>");
                out.println("<h1 style=\"text-align:center\">" + calcula.CalculaOperacao(num1, num2) + "</h1>");
            }
                out.println("</fieldset>");
                out.println("<p><a href='index.html'>Nova Operação</a></p>");
                out.println("</fieldset>");
                out.println("</body>");
                out.println("</html>");

        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("<html><head></head><body onload=\"alert('Números inválidos, tente novamente')\"></body></html>");
            out.println("<meta http-equiv='refresh' content='0.1; URL=index.html'>");
            // show a generic error page
        }

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
