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
}
