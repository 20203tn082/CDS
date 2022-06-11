<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 01/06/2022
  Time: 12:34 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>Holi desde index</p>
<%-- Mando el endpoint --%>
<a href="listaCategorias"> Link a la lista de categorías</a>
<script >
    const consultar = async () => {
        try {
            const response = await fetch(
                "http://localhost:8080/Prueba3/consultaGeneral"
            );
            const data = await response.json();
            console.log(data);
        } catch (e) {
            console.log(e);
        }
    };
    consultar();
</script>
</body>
</html>
