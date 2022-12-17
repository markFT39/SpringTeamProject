<%@ page contentType="text/html;charset=UTF-8"
         language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

<head>
    <title>Calendar Service</title>
    <script>
        function delete_ok(id) {
            var a = confirm("정말로 일정을 삭제하겠습니까?");
            if (a) location.href = 'deleteok/' + id;
        }
    </script>
<%--    <link rel="stylesheet" href="${path}/resource/css/sytle.css">--%>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #list tr:nth-child(even){background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Calendar Service</h1>
    <p>${userName}님 안녕하세요!</p>
    <a href="../login/logout">로그아웃</a>

<form action="userList", method="post">
    <table>
        <tr>
            <td>사용자 검색: <input type="text" name="user_name"/></td>
        </tr>
    </table>
    <button type="submit">검색하기</button>
    <button type="button" onclick="location.href='list'">검색 조건 초기화</button>
</form>

    <table id="list" width="90%">
        <tr>
            <th>No.</th>
            <th>Schedule Name</th>
            <th>Writer</th>
            <th>Content</th>
<%--            <th>Photo</th>--%>
            <th>Date</th>
            <th>Vote(추천:비추천)</th>
            <th>Voting Status</th>
            <th>Like / Dislike</th>
        </tr>

        <c:forEach items="${list}" var="u" varStatus="status">
            <tr>
                <td>${fn:length(list)-status.index}</td>
                <td><a href="view/${u.getSeq()}">${u.schedule_name}</a></td>
                <td>${u.writer}</td>
                <td>${u.content}</td>
<%--                <td>${u.photo}</td>--%>
                <td>${u.start_date} ~ ${u.end_date}</td>
                <td>${u.user_like} : ${u.user_dislike}</td>
                <td><c:choose>
                    <c:when test="${u.voting_status == 1}">투표 가능</c:when>
                    <c:when test="${u.voting_status == 0}">투표 불가능</c:when>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${userName == u.writer || userName == '관리자'}"><a href="editform/${u.seq}">일정 수정하기 / </a></c:when>
                    <c:when test="${userName != u.writer && u.voting_status == 1}"><a href="likeCalendar/${u.seq}">추천하기 / </c:when>
                        <%-- <c:otherwise>추천이 불가능합니다.</c:otherwise> --%>
                </c:choose>
                        <c:choose>
                    <c:when test="${userName == u.writer || userName == '관리자'}"><a href="javascript:delete_ok('${u.seq}')">일정 삭제하기</a></c:when>
                    <c:when test="${userName != u.writer && u.voting_status == 1}"><a href="dislikeCalendar/${u.seq}">비추천하기</c:when>
                        <c:otherwise>추천이 불가능합니다.</c:otherwise>
                </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/><button type="button" onclick="location.href= 'add'">Add New Schedule</button>
</div>
</body>
</html>