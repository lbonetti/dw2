<%-- 
    Document   : icliente
    Created on : 23/11/2015, 20:23:37
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusão de Clientes</title>
    </head>
    <body><center><font size="6">
        Formulário para inclusão de novo Cliente
        <form action="ServClientes?l=ic" method="POST">
            CPF: <input type="text" name="cpf" size="11" maxlength="11" value="" /><br>
            Nome: <input type="text" name="nome" size="50" maxlength="50" value="" /><br>
            <input type="submit" value="Enviar" />        
        </form>
        </font></center></body>
</html>
