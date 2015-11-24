/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Aluno
 */
public class Cliente
{

  private String cpf;
  private String nome;

  public Cliente()
  {
  }

  public Cliente(String v_cpf, String v_nome)
  {
    this.cpf = v_cpf;
    this.nome = v_nome;
  }

  public void setCpf(String v_cpf)
  {
    this.cpf = v_cpf;
  }

  public void setNome(String v_nome)
  {
    this.nome = v_nome;
  }

  public String getCpf()
  {
    return cpf;
  }

  public String getNome()
  {
    return nome;
  }
}
