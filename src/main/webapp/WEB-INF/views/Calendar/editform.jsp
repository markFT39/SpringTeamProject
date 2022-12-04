<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Schedule Form</title>
</head>
<body>

<h1>Edit Form</h1>
<form:form modelAttribute="u" method="POST" action="../editok">
    <form:hidden path="seq"/>
    <table id="edit">
        <tr>
            <td>Schedule Name:</td>
            <td><form:input path="schedule_name"/></td>
        </tr>
        <tr>
            <td>Writer:</td>
            <td><form:input path="writer"/></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><form:textarea cols="50" rows="5" path="content"></form:textarea></td>
        </tr>
        <tr>
            <td>Start Date:</td>
            <td><input type="date" path="start_date"/></td>
        </tr>
        <tr>
            <td>End Date:</td>
            <td><input type="date" path="end_date"/></td>
        </tr>
    </table>
    <button type="button" value="Cancel" onclick="history.back()">View all Schedule</button>
    <button type="submit">Edit Schedule</button>
</form:form>

</body>
</html>