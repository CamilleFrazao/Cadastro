<%-- 
    Document   : index
    Created on : 23/03/2016, 11:27:50
    Author     : Camille
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>

            <form  action="cadastro" method="post">

                Rg: <input type="text" name="cadPesRg" />
                NOME: <input type = "text" name="cadPesNome"/><br/>
                Cpf: <input type="text" name="cadPesCpf"/>
                Nascimento: <input type="date" name="cadPesNas"/>
                Endereço: <input type="text" name="cadPesEnd"/>

                <input type="submit"  name="ok" />

            </form>

        </div>

        <div>

            <c:forEach items="${pessoas}" var="id">

                <div>${id.getRg()}</div>
                <div>${id.getNome()}</div>
                <div>${id.getCpf()}</div>
                <div>${id.getEndereco()}</div>
                <div>${id.getNascimento()}</div>

            </c:forEach>


        </div>

    </body>
</html>
