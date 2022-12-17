<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.dao.CalendarDAO, com.example.vo.CalendarVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>
<meta charset="UTF-8">
<title>Detail Page</title>
<body>
<%
    /*
    CalendarDAO calendarDAO = new CalendarDAO();
    String id = request.getParameter("id");
    CalendarVO u = calendarDAO.getCalendar(Integer.parseInt(id));
    request.setAttribute("vo",u);
     */
%>
<h1>${schedule_name}</h1>
<table id="edit" modelAttribute="u">
  <tr><td>Schedule Name</td><td>${u.schedule_name}</td></tr>
  <tr><td>Writer</td><td>${u.writer}</td></tr>
  <tr><td>Date</td><td>${u.start_date} ~ ${u.end_date}</td></tr>
<%--  <tr>--%>
<%--    ${vo.getPhoto()}--%>
<%--    ${pageContext.request.contextPath}--%>
<%--    <td>Photo</td><td><c:if test="${vo.getPhoto() ne ''}"><br />--%>
<%--    <img src="${pageContext.request.contextPath}/upload/${vo.getPhoto()}" class="photo"></c:if></td>--%>
<%--  </tr>--%>
  <tr><td>Content</td><td>${u.content}</td></tr>
  <tr><td>Vote</td><td>${u.user_like} : ${u.user_dislike}</td></tr>
  <tr><td>Voting Status</td><td>${u.voting_status}</td></tr>

  추천하기 비추천하기
</table>
<button type="button" onclick="history.back()">Back</button>
<!--<button type="button" onclick="location.href='../editform/${u.seq}'">Edit</button>
<td><a href="editform/${u.seq}">Edit</a>-->

</body>
</html>