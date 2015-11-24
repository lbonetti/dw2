/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ServClientes", urlPatterns =
{
  "/ServClientes"
})
public class ServClientes extends HttpServlet
{

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
          throws ServletException, IOException
  {
    response.setContentType("text/html;charset=UTF-8");
    String l = request.getParameter("l");
    dao.Cliente cl = new dao.Cliente(request.getParameter("cpf"), request.getParameter("nome"));
    String msg="";
    
    try (PrintWriter out = response.getWriter())
    {
      if("ic".equals(l)){
        if("".equals(cl.getCpf()) || "".equals(cl.getNome()))
          msg="Campos obrigatórios não preenchidos.";
        else
          msg=dao.mcliente.icliente(cl);
      }
      else{msg="Não implementada a opção " + l;
        
      }
      
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Clientes</title>");      
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Opção " + l + "</h1>");
      out.println("<h1>CPF " + cl.getCpf() + " NOME " + cl.getNome() + "</h1>");
      out.println("<h1>Mensagem: " + msg + "</h1>");
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
          throws ServletException, IOException
  {
    processRequest(request, response);
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
          throws ServletException, IOException
  {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo()
  {
    return "Short description";
  }// </editor-fold>

}