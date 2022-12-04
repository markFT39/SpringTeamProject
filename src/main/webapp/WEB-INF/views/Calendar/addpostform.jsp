<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Schedule</title>
</head>
<body>

<h1>Add New Schedule</h1>
<form action="addok" method="post">
    <table>
        <tr>
            <td>Schedule Name:</td>
            <td><input type="text" name="schedule_name"/></td>
        </tr>
        <tr>
            <td>Writer:</td>
            <td><input type="text" name="writer"/></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><textarea cols="50" rows="5" name="content"></textarea></td>
        </tr>
        <tr>
            <td>Start Date:</td>
            <td><input type="date" name="start_date"/></td>
        </tr>
        <tr>
            <td>End Date:</td>
            <td><input type="date" name="end_date"/></td>
        </tr>
    </table>
    <button type="button" onclick="location.href='list'">View all Schedule</button>
    <button type="submit">Add Schedule</button>
</form>
</body>
</html>