<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<%--
  Created by IntelliJ IDEA.
  User: I am
  Date: 18.05.2019
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Store</title>
    <style>
        body {
            margin: 25px;
        }
    </style>
</head>
<body>
<h2>Parts list</h2>

<c:url var="searchUrl" value="/my-parts-list/store/main/search" />
<form:form method="GET" action="${saveUrl}">
    <input type="text" name="search" /> &nbsp;
    <input type="submit" value="Search" />
</form:form>

<p></p>
<c:url var="switchUrl" value="/my-parts-list/store/main/1" />
<form:form method="GET" action="${switchUrl}">
    Please select:
    <div>
        <input type="radio" id="part1"
               name="choice" value="allParts" checked>
        <label for="part1">All parts</label>

        <input type="radio" id="part2"
               name="choice" value="trueParts">
        <label for="part2">Only necessity parts</label>

        <input type="radio" id="part3"
               name="choice" value="notTrueParts">
        <label for="part3">Not necessity parts</label>
    </div>
    <div>
        <button type="submit">Submit</button>
    </div>
</form:form>
<p></p>
<c:url var="mainUrl" value="/my-parts-list/store/main/1?choice=trueParts" />
<form:form method="GET" action="${mainUrl}">
    <input type="submit" value="Return" />
</form:form>
<p></p>
<c:url var="addUrl" value="/my-parts-list/store/main/add" />
<form:form method="GET" action="${addUrl}">
    <input type="submit" value="Add" />
</form:form>

<c:if test="${not empty components}">
    <table style="border: 1px solid black; width: 500px; text-align:center">
        <thead style="background:#65b9ff">
        <tr>
            <th>Name of parts</th>
            <th>Necessity</th>
            <th>Amount</th>
            <th colspan="3"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${components}" var="component">
            <c:url var="editUrl" value="/my-parts-list/store/main/edit?id=${component.id}" />
            <c:url var="deleteUrl" value="/my-parts-list/store/main/delete?id=${component.id}" />
            <tr>
                <td style="border-left:1px solid black;"><c:out value="${component.name}" /></td>
                <td>
                    <c:if test="${component.necessity eq true}">
                        Yes
                    </c:if>
                    <c:if test="${component.necessity eq false}">
                        No
                    </c:if>
                </td>
                <td><c:out value="${component.amount}" /></td>
                <td><a href="${editUrl}">Edit</a></td>
                <td style="border-right:1px solid black;"><a href="${deleteUrl}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<p></p>


<c:if test="${empty components}">
    Parts not found.
</c:if>


</body>
</html>
