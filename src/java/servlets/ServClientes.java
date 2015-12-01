/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    PrintWriter out = response.getWriter();
    try 
    {
      if("ic".equals(l)){
        if("".equals(cl.getCpf()) || "".equals(cl.getNome()))
          msg="Campos obrigatórios não preenchidos.";       
        else
          msg=dao.mcliente.icliente(cl);
      }
      else
      if("lc".equals(l))
        {
           ResultSet rs = dao.mcliente.lcliente(cl);
           if (rs==null) msg="Nenhum Cliente Cadastrado";
           else
           {
             msg+="<table border='1'>";
             rs.first();
             do
             {
              msg+="<tr><td>"+rs.getString("cpf")+"</td><td>"+rs.getString("nome")+"</td></tr>";
             } while (rs.next());
           }
        }
      else
      if ("ac".equals(l))
         {ResultSet rs = dao.mcliente.lcliente(cl);
          if(rs==null) msg="Cliente não encontrado para alterar";
          else{cl.setCpf(rs.getString("cpf")); cl.setNome(rs.getString("nome"));
               out.println("<form action='ServClientes?l=aac' method='post'>");
               out.println(cl.getCpf()+"  CPF: <input type='hidden' name='cpf' value='"+
                           cl.getCpf()+"'/><br>");
               out.println("Altere Nome do Cliente: <input type='text' name='nome' value='"+
                           cl.getNome()+"'/><br>");         
               out.println("<input type='submit' value='Alterar' /></form>");} 
         }
      else
      if ("aac".equals(l))
      {String rs = dao.mcliente.acliente(cl);
       if ("1".equals(rs))
          {msg = "Cliente alterado";}
       else msg=rs;   
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
      out.println("<br>" + msg);
      out.println("</body>");
      out.println("</html>");
    }
    catch(SQLException e)
            {
              out.println("Erro "+e);
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
