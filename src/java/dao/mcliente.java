package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Aluno ------- Manutenção de Tipos ----------
 */
public class mcliente
{

/* ------Inclusão de Tipos -----------*/


  public static String icliente(Cliente cl)
  {
    Connection conn = null;
    try
    {
      conn = ConexaoManutencao.getConexao();
      String sql = "INSERT INTO cliente (cpf, nome) values (?,?)";
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, cl.getCpf());
      stmt.setString(2, cl.getNome());
      stmt.execute();
      stmt.close();
      ConexaoManutencao.closeAll(conn);
      return "Cliente Incluido";
    }
    catch (Exception e)
    {
      String msg = "Erro: " + e;
      return msg;
    }
  }
  
  public static ResultSet lcliente(Cliente cl){
    Connection conn = null;
    try { conn=ConexaoManutencao.getConexao();
          String sql="SELECT * FROM cliente ";
          if(cl.getCpf()!=null)
            sql+="WHERE cpf='"+cl.getCpf()+"'";
          Statement st = conn.createStatement();
          ResultSet rs = st.executeQuery(sql);
          rs.last();
          int n = rs.getRow();
          if (n==0) return null;
          else return rs;
    }
    catch (Exception e){String msg = "Error "+ e; 
    return null;}
  }
  
    public static String acliente(Cliente cl){
  Connection conn = null;
  try { conn=ConexaoManutencao.getConexao();
        String sql="UPDATE cliente SET nome='"+cl.getNome();
        sql += "' WHERE cpf='"+cl.getCpf()+"'";
        Statement st = conn.createStatement();
        int rs = st.executeUpdate(sql);
        return String.valueOf(rs);
  } catch (SQLException e){return "Erro "+e.getMessage();}
  }
}
