<%-- Document   : atipo
     Created on : 28/09/2015, 19:52:02
     Author     : Aluno --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html><head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head><body>
      <form action="ServClientes?l=ac" method="POST">
          Selecione o Cliente: <SELECT name="cpf">
              <sql:setDataSource var="dataSource"
                         driver="com.mysql.jdbc.Driver"
                         url="jdbc:mysql://localhost:3306/clientes"
                         user="root" password="ifsp"/>
              <sql:query var="cliente" dataSource="${dataSource}">
               SELECT * FROM cliente
              </sql:query>
              <c:forEach var="row" items="${cliente.rows}">
                 <option value=<c:out value="${row.cpf}"/>>
                     <c:out value="${row.nome}"/></option>
              </c:forEach>
          </SELECT>    
      <input type="submit" value="Enviar" />   
      </form></body>
</html>
