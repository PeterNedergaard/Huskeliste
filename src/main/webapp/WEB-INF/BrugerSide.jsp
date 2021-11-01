<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 25/10/2021
  Time: 21.23
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.huskelistetomcat.EmneTilfoej" %>
<%@ page import="com.example.huskelistetomcat.Emne" %>

<html>
<head>
    <title>Bruger siden</title>
</head>
<body>

<h1>Velkommen til brugersiden. Du er logget ind som ${sessionScope.navn}</h1>

Her kan du oprette emner til din huskeseddel:


<form action="Emnetilføoej" , method="get">

    <label for="name">nyt emne:</label><br>
    <input type="text" id="name" name="emne" value="" placeholder="fx. Ølbong!"><br>

    <input type="submit" value="opret">

</form>

<br>
<br>
<br>

<c:forEach items="${sessionScope.emneListe}" var="emne">

    <ul>
        <li>
        ${emne}
        </li>
    </ul>

</c:forEach>


</body>
</html>
