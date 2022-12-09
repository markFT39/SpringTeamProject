<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Schedule Form</title>
    <script>
        if(document.getElementById("voting_status").checked) {
            document.getElementById("voting_status_hidden").disabled = true;
        }
    </script>
</head>
<body>

<h1>Edit Form</h1>
<form:form modelAttribute="u" method="POST" id="editSchedule" action="../editok" onsubmit="return validateFormEdit()">
    <form:hidden path="seq"/>
    <table id="edit">
        <tr>
            <td>Schedule Name:</td>
            <td><form:input path="schedule_name" id="schedule_name" name="schedule_name" /></td>
        </tr>
        <tr>
            <td>Writer:</td>
            <td><form:input path="writer" id="writer" name="writer"/></td>
        </tr>
        <tr>
            <td>Content:</td>
            <td><form:textarea cols="50" rows="5" path="content" id="content" name="content"></form:textarea></td>
        </tr>
        <tr>
            <td>Start Date:</td>
            <td><form:input type="date" path="start_date" id="start_date" name="start_date"/></td>
        </tr>
        <tr>
            <td>End Date:</td>
            <td><form:input type="date" path="end_date" id="end_date" name="end_date"/></td>
        </tr>
        <tr>
            <td>Allowing Voting:</td>
            <td><form:checkbox name="voting_status" value="1" id="voting_status" path="voting_status"/></td>
            <td><input type="hidden" name="voting_status" value="0" id="voting_status_hidden"></td>
        </tr>
    </table>
    <button type="button" value="Cancel" onclick="history.back()">View all Schedule</button>
    <button type="submit">Edit Schedule</button>
</form:form>
<script>
    function validateFormEdit() {
        /*const edit = document.querySelector("#schedule_name")
        * console.log(edit.value)
        * */
        const schedule_name  = document.getElementById("schedule_name");
        if (schedule_name.value == null || schedule_name.value === "") {
            alert("일정 이름을 입력하세요");
            schedule_name.focus();
            return false;
        }

        const writer  = document.getElementById("writer");
        if (writer.value === "") {
            alert("작성자명을 입력하세요")
            writer.focus();
            return false;
        }

        const content  = document.getElementById("content");
        if (content.value === "") {
            alert("일정 내용을 입력하세요")
            content.focus();
            return false;
        }

        const start_date  = document.getElementById("start_date");
        if (start_date.value === "") {
            alert("시작일을 입력하세요")
            return false;
        }

        const end_date  = document.getElementById("end_date");
        if (end_date.value === "") {
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

        const val = confirm("일정을 수정 하시겠습니까?");
        if (!val) {
            return false;
        }

        return true;
    }
</script>
</body>
</html>