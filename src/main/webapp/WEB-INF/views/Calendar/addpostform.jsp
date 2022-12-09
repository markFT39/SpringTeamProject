<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Schedule</title>
    <script>
        if(document.getElementById("voting_status").checked) {
            document.getElementById("voting_status_hidden").disabled = true;
        }
    </script>
</head>
<body>

<h1>Add New Schedule</h1>
<form action="addok" method="post" name="addSchedule" onsubmit="return validateForm()">
    <table>
        <tr>
            <td>Schedule Name:</td>
            <td><input type="text" name="schedule_name"/></td>
        </tr>
        <tr>
            <td>Writer:</td>
            <td><input type="text" name="writer" value="${userName}" readonly/></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><textarea cols="50" rows="5" name="content"></textarea></td>
        </tr>
        <tr>
            <td>Start Date:</td>
            <td><input type="date" name="start_date" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <td>End Date:</td>
            <td><input type="date" name="end_date" pattern="yyyy-MM-dd"/></td>
        </tr>
        <tr>
            <td>Allowing Voting:</td>
            <td><input type="checkbox" name="voting_status" value="1" id="voting_status"/></td>
            <td><input type="hidden" name="voting_status" value="0" id="voting_status_hidden"></td>
        </tr>
    </table>
    <button type="button" onclick="location.href='list'">View all Schedule</button>
    <button type="submit">Add Schedule</button>
</form>
    <script>
        function validateForm() {
            const schedule_name = document.addSchedule.schedule_name;
            if (schedule_name.value == "") {
                alert("일정 이름을 입력하세요");
                schedule_name.focus();
                return false;
            }

            const content = document.addSchedule.content;
            if (content.value == "") {
                alert("일정 내용을 입력하세요")
                content.focus();
                return false;
            }

            const start_date = document.addSchedule.start_date;
            if (start_date.value == "") {
                alert("시작일을 입력하세요")
                return false;
            }

            const end_date = document.addSchedule.end_date;
            if (end_date.value == "") {
                alert("마감일를 입력하세요")
                end_date.focus();
                return false;
            }

            const date1 = new Date(start_date.value);
            const date2 = new Date(end_date.value);

            if (date1 > date2) {
                alert("시작일이 마감일보다 뒤에 있습니다!")
                start_date.focus();
                return false;
            }

            const val = confirm("일정을 추가 하시겠습니까?");
            if (!val) {
                return false;
            }

            return true;
        }
    </script>
</body>
</html>