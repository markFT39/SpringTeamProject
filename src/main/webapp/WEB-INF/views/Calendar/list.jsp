<%@ page contentType="text/html;charset=UTF-8"
         language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Calendar Service</title>
    <style>
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        #list tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #list tr:hover {
            background-color: #ddd;
        }

        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }
    </style>
    <script>
        function delete_ok(id) {
            var a = confirm("정말로 일정을 삭제하겠습니까?");
            if (a) location.href = 'deleteok/' + id;
        }
    </script>
</head>
<body>
<h1>Calendar Service</h1>
<p>${userName}님 안녕하세요!</p>
<a href="../login/logout">로그아웃</a>
    <table id="list" width="90%">
        <tr>
            <th>No.</th>
            <th>Schedule Name</th>
            <th>Writer</th>
            <th>Content</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Like</th>
            <th>Dislike</th>
            <th>Voting Status</th>
            <th>Like(Edit)</th>
            <th>Dislike(Delete)</th>
        </tr>

        <c:forEach items="${list}" var="u" varStatus="status">
            <tr>
                <td>${fn:length(list)-status.index}</td>
                <td>${u.schedule_name}</td>
                <td>${u.writer}</td>
                <td>${u.content}</td>
                <td>${u.start_date}</td>
                <td>${u.end_date}</td>
                <td>${u.user_like}</td>
                <td>${u.user_dislike}</td>
                <td><c:choose>
                    <c:when test="${u.voting_status == 1}">투표 가능</c:when>
                    <c:when test="${u.voting_status == 0}">투표 불가능</c:when>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${userName == u.writer}"><a href="editform/${u.seq}">Schedule Edit</a></c:when>
                    <c:when test="${userName != u.writer && u.voting_status == 1}"><a href="likeCalendar/${u.seq}">추천하기</c:when>
                        <c:otherwise>추천이 불가능합니다.</c:otherwise>
                </c:choose>
                    </td>
                <td><c:choose>
                    <c:when test="${userName == u.writer}"><a href="javascript:delete_ok('${u.seq}')">Schedule Delete</a></c:when>
                    <c:when test="${userName != u.writer && u.voting_status == 1}"><a href="dislikeCalendar/${u.seq}">비추천하기</c:when>
                        <c:otherwise>추천이 불가능합니다.</c:otherwise>
                </c:choose>

                </td>
            </tr>
        </c:forEach>
    </table>

    <br/><button type="button" onclick="location.href= 'add'">Add New Schedule</button>
</body>
</html>