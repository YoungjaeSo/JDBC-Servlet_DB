<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>유저 추가</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/insertUser" method="post">
        <fieldset>
            <legend>유저 목록 추가하기</legend>
            <label for="name">이름 :</label>
            <input type="text" id="name" name="name"><br><br>
            <label for="email">이메일 : </label>
            <input type="text" id="email" name="email"><br><br>
            <label for="age">나이 : </label>
            <input type="text" id="age" name="age"> <br><br>
            <label for="password">비밀번호 :</label>
            <input type="password" id="password" name="password"><br><br>
            <button type="submit">등록</button>
        </fieldset>
    </form>
</body>
</html>
